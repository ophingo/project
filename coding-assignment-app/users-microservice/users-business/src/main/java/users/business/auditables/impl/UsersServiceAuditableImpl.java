package users.business.auditables.impl;

import users.business.auditables.api.UsersServiceAuditable;
import users.domain.EntityStatus;
import users.domain.Users;
import users.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UsersServiceAuditableImpl  implements UsersServiceAuditable {

    private UsersRepository usersRepository;

    public UsersServiceAuditableImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findByIdAndEntityStatusIsNot(id, EntityStatus.DELETED);
    }

    @Override
    public List<Users> findByFirstname(String name) {
        return usersRepository.findAllByFirstnameAndEntityStatusIsNot(name, EntityStatus.DELETED);

    }
    @Override
    public List<Users> findBySurname(String surname) {
        return usersRepository.findAllBySurnameAndEntityStatusIsNot(surname, EntityStatus.DELETED);

    }

    @Override
    public Users create(Users users, String username) {
        return usersRepository.save(users);
    }


    @Override
    public Users edit(Users users, String username) {
        return usersRepository.save(users);
    }
}

