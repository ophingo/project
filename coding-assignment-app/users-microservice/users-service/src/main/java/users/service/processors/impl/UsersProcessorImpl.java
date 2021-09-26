package users.service.processors.impl;

import coding.assignment.utils.messages.UsersResponse;
import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import users.business.logic.api.UsersService;
import users.service.processors.api.UsersProcessor;

import java.util.Locale;

public class UsersProcessorImpl implements UsersProcessor {
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final UsersService usersService;

    public UsersProcessorImpl(UsersService usersService) {
        this.usersService = usersService;
    }

    public UsersResponse save(UserCreationRequest request, Locale locale, String username) {
        log.info("Incoming request to create a user profile {}", request);
        UsersResponse response = usersService.create(request, locale, username);
        log.info("Outgoing response for creating a user profile {}", response);
        return response;
    }

    @Override
    public UsersResponse edit(UserRequest request, Locale locale, String username) {
        log.info("Incoming request to edit a user profile {}", request);
        UsersResponse response = usersService.edit(request, locale, username);
        log.info("Outgoing response for updating a user profile {}", response);
        return response;
    }

    @Override
    public UsersResponse findById(Long id, Locale locale){
        log.info("Incoming request for retrieving a user using id : {}", id);
        UsersResponse response = usersService.findById(id, locale);
        log.info("Outgoing response for retrieving a user : {} ", response);
        return response;
    }

    @Override
    public UsersResponse findByFirstname(String firstname, Locale locale){
        log.info("Incoming request for retrieving a user using first name : {}", firstname);
        UsersResponse response = usersService.findByFirstname(firstname, locale);
        log.info("Outgoing response for retrieving a user : {} ", response);
        return response;
    }

    @Override
    public UsersResponse findBySurname(String surname, Locale locale){
        log.info("Incoming request for retrieving a user using surname : {}", surname);
        UsersResponse response = usersService.findBySurname(surname, locale);
        log.info("Outgoing response for retrieving a user : {} ", response);
        return response;
    }


    @Override
    public UsersResponse delete(Long id, Locale locale, String username){
        log.info("Incoming request to delete a user with id : {}", id);
        UsersResponse response = usersService.delete(id, locale, username);
        log.info("Outgoing response for delete user request {} ", response);
        return response;
    }
}
