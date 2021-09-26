package users.service.processors.api;

import coding.assignment.utils.messages.UsersResponse;
import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;

import java.util.Locale;

public interface UsersProcessor {
    UsersResponse save(UserCreationRequest request, Locale locale, String username);

    UsersResponse edit(UserRequest request, Locale locale, String username);

    UsersResponse findById(Long id, Locale locale);

    UsersResponse findByFirstname(String branchName, Locale locale);

    UsersResponse findBySurname(String surname, Locale locale);

    UsersResponse delete(Long id, Locale locale, String username);
}
