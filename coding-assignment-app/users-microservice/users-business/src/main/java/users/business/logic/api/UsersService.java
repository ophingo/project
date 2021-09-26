package users.business.logic.api;

import coding.assignment.utils.messages.UsersResponse;
import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;

import java.util.Locale;

public interface UsersService {

    UsersResponse create(UserCreationRequest userCreationRequest, Locale locale, String username);
    UsersResponse edit(UserRequest userRequest, Locale locale, String username);
//    UsersResponse findAll(Locale locale);
    UsersResponse findById(Long id, Locale locale);
    UsersResponse findByFirstname(String name, Locale locale);
    UsersResponse findBySurname(String Surname, Locale locale);
    UsersResponse delete(Long id, Locale locale, String username);
}
