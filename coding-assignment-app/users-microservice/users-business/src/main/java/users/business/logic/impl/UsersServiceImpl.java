package users.business.logic.impl;

import coding.assignment.utils.dtos.UsersDto;
import coding.assignment.utils.enums.I18Code;
import coding.assignment.utils.enums.ResponseCode;
import coding.assignment.utils.i18.api.MessageService;
import coding.assignment.utils.mappers.UsersMapper;
import coding.assignment.utils.messages.UsersResponse;
import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;
import users.business.auditables.api.UsersServiceAuditable;
import users.business.logic.api.UsersService;
import users.business.validations.api.UsersServiceValidator;
import users.domain.EntityStatus;
import users.domain.Title;
import users.domain.Users;
import users.repository.UsersRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    private MessageService messageService;
    private UsersServiceAuditable usersServiceAuditable;
    private UsersServiceValidator usersServiceValidator;
    private UsersMapper usersMapper;
    private UsersRepository usersRepository;

    public UsersServiceImpl(MessageService messageService, UsersServiceAuditable usersServiceAuditable, UsersServiceValidator usersServiceValidator, UsersMapper usersMapper, UsersRepository usersRepository) {
        this.messageService = messageService;
        this.usersServiceAuditable = usersServiceAuditable;
        this.usersServiceValidator = usersServiceValidator;
        this.usersMapper = usersMapper;
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersResponse create(UserCreationRequest userCreationRequest, Locale locale, String username) {
        String message;
        Boolean isRequestValid = usersServiceValidator.isRequestValid(userCreationRequest);

        if (isRequestValid) {

            Users users = usersMapper.map(userCreationRequest);
            Users bankCreated = usersServiceAuditable.create(users, username);
            UsersDto usersDto = usersMapper.map(bankCreated);
            message = messageService.getMessage(I18Code.MESSAGE_USER_CREATE_REQUEST_SUCCESSFUL.getCode(),
                    new String[]{}, locale);
            return new UsersResponse(true, message, ResponseCode.CREATED.getCode(), usersDto, null);
        }

        message = messageService.getMessage(I18Code.MESSAGE_INVALID_USER_CREATE_REQUEST.getCode(),
                new String[]{}, locale);
        return new UsersResponse(false, message, ResponseCode.FAILED.getCode(), null, null);
    }


    @Override
    public UsersResponse edit(UserRequest userRequest, Locale locale, String username) {
        String message;
        Boolean isRequestValid = usersServiceValidator.isRequestValid(userRequest);
        if (isRequestValid) {
            Optional<Users> existingUsersWithSameId = usersRepository.findByIdAndEntityStatusIsNot(userRequest.getId(), EntityStatus.DELETED);

            Users user = existingUsersWithSameId.get();
            user.setFirstname(userRequest.getFirstname());
            user.setSurname(userRequest.getSurname());
            user.setDateOfBirth(userRequest.getDateOfBirth());
            user.setJobTitle(userRequest.getJobTitle());
            user.setTitle(Title.getEnumFromString(userRequest.getTitle()));

            Users userEdited = usersServiceAuditable.edit(user, username);
            UsersDto usersDto = usersMapper.map(userEdited);
            message = messageService.getMessage(I18Code.MESSAGE_USER_EDIT_SUCCESSFULLY.getCode(),
                    new String[]{}, locale);
            return new UsersResponse(true, message, ResponseCode.SUCCESSFUL.getCode(), usersDto, null);
        }

        message = messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                new String[]{}, locale);
        return new UsersResponse(false, message, ResponseCode.NOT_FOUND.getCode(), null, null);
    }


    @Override
    public UsersResponse findById(Long id, Locale locale) {
        String message;
        Optional<Users> user = usersRepository.findByIdAndEntityStatusIsNot(id, EntityStatus.DELETED);
        if (user.isPresent()) {
            UsersDto usersDto = usersMapper.map(user.get());
            message = messageService.getMessage(I18Code.MESSAGE_USER_RETRIEVE_SUCCESS.getCode(),
                    new String[]{}, locale);
            return new UsersResponse(true, message, ResponseCode.SUCCESSFUL.getCode(), usersDto, null);
        }
        message = messageService.getMessage(I18Code.MESSAGE_USER_ID_NOT_FOUND.getCode(),
                new String[]{}, locale);
        return new UsersResponse(false, message, ResponseCode.NOT_FOUND.getCode(), null, null);
    }

    @Override
    public UsersResponse findByFirstname(String firstname, Locale locale) {
        String message = "";

        List<Users> usersList = usersServiceAuditable.findByFirstname(firstname);
        if (!usersList.isEmpty()) {

            List<UsersDto> usersDtoList = usersMapper.map(usersList);

            message = messageService.getMessage(I18Code.MESSAGE_USER_RETRIEVE_SUCCESS.getCode(),
                    new String[]{}, locale);

            return new UsersResponse(true, message, ResponseCode.SUCCESSFUL.getCode(), null, usersDtoList);

        }
        message = messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                new String[]{}, locale);
        return new UsersResponse(false, message, ResponseCode.NOT_FOUND.getCode(), null, null);
    }


    @Override
    public UsersResponse findBySurname(String surname, Locale locale) {
        String message = "";

        List<Users> usersList = usersServiceAuditable.findBySurname(surname);
        if (!usersList.isEmpty()) {

            List<UsersDto> usersDtoList = usersMapper.map(usersList);

            message = messageService.getMessage(I18Code.MESSAGE_USER_RETRIEVE_SUCCESS.getCode(),
                    new String[]{}, locale);

            return new UsersResponse(true, message, ResponseCode.SUCCESSFUL.getCode(), null, usersDtoList);

        }
        message = messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                new String[]{}, locale);
        return new UsersResponse(false, message, ResponseCode.NOT_FOUND.getCode(), null, null);
    }

    @Override
    public UsersResponse delete(Long id, Locale locale, String username) {
        String message;
        Optional<Users> existingUsers = usersRepository.findByIdAndEntityStatusIsNot(id, EntityStatus.DELETED);
        if (existingUsers.isPresent()) {

            existingUsers.get().setEntityStatus(EntityStatus.DELETED);
            usersServiceAuditable.edit(existingUsers.get(), username);
            message = messageService.getMessage(I18Code.MESSAGE_USER_DELETE_SUCCESS.getCode(),
                    new String[]{}, locale);
            return new UsersResponse(true, message, ResponseCode.SUCCESSFUL.getCode(), null, null);

        }
        message = messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                new String[]{}, locale);
        return new UsersResponse(false, message, ResponseCode.NOT_FOUND.getCode(), null, null);
    }
}

