package storage.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import storage.storage.models.Role;
import storage.storage.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> getUsersByRole(Role role);
    Optional<User> findById(long id);
    List<User> findAll();

}