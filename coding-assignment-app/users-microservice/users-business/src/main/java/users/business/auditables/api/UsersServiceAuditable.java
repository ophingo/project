package users.business.auditables.api;

import users.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UsersServiceAuditable {

    Optional<Users> findById(Long id);
    List<Users> findByFirstname(String name);
    List<Users> findBySurname(String surnam);
    Users create(Users users, String username);
    Users edit(Users applicationDocuments, String username);
}
