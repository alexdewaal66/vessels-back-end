package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.User;
import nl.alexdewaal66.novi.vessels.model.UserSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT u.username FROM users u", nativeQuery = true)
    Collection<String> getAllIds();

    Collection<UserSummary> findAllUserSummariesBy();

}
