package users.business.validations.api;

import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;

public interface UsersServiceValidator {
    Boolean isRequestValid(UserCreationRequest request);

    Boolean isRequestValid(UserRequest request);
}
