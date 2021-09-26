package users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import users.domain.EntityStatus;
import users.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

    List<Users> findAllByFirstnameAndEntityStatusIsNot(String firstname, EntityStatus entityStatus);

    List<Users> findAllBySurnameAndEntityStatusIsNot(String surname, EntityStatus entityStatus);

    Optional<Users> findByIdAndEntityStatusIsNot(Long id, EntityStatus entityStatus);
    Users save(Users users);

}
