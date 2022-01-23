package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Authority;
import nl.alexdewaal66.novi.vessels.model.User;
import nl.alexdewaal66.novi.vessels.model.UserSummaryProjection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    String createUser(User user);

    Collection<String> getAllIds();
    Collection<User> getUsers();
    Collection<UserSummaryProjection> getUserSummaries();

    Optional<User> getUser(String username);

    List<User> getByIds(List<String> usernames);

    void updateUser(String username, User user);

    void deleteUser(String username);

    boolean userExists(String username);

    Set<Authority> getAuthorities(String username);
    void addAuthority(String username, String authority);
    void removeAuthority(String username, String authority);

}