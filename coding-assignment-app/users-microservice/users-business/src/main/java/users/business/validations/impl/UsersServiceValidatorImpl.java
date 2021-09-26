package users.business.validations.impl;

import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;
import users.business.validations.api.UsersServiceValidator;

public class UsersServiceValidatorImpl implements UsersServiceValidator {
    @Override
    public Boolean isRequestValid(UserCreationRequest request) {
        if(request == null || request.getFirstname() == null || request.getFirstname().trim().isEmpty()
                            ||request.getSurname() ==null || request.getSurname().trim().isEmpty()
                            ||request.getTitle() == null || request.getTitle().trim().isEmpty()
                            ||request.getJobTitle() == null || request.getJobTitle().trim().isEmpty()
                            ||request.getDateOfBirth() == null  ){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean isRequestValid(UserRequest request) {
        if(request == null || request.getId() == null || request.getFirstname() == null || request.getFirstname().trim().isEmpty()
                ||request.getSurname() ==null || request.getSurname().trim().isEmpty()
                ||request.getTitle() == null || request.getTitle().trim().isEmpty()
                ||request.getJobTitle() == null || request.getJobTitle().trim().isEmpty()
                ||request.getDateOfBirth() == null  ){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
