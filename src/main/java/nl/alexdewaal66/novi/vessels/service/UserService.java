package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Authority;
import nl.alexdewaal66.novi.vessels.model.EndUser;
import nl.alexdewaal66.novi.vessels.model.UserSummary;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    String createUser(EndUser endUser);

    Collection<String> getAllIds();
    Collection<EndUser> getUsers();
    Collection<UserSummary> getUserSummaries();

    Optional<EndUser> getUser(String username);

    List<EndUser> getByIds(List<String> usernames);

    void updateUser(String username, EndUser endUser);

    void deleteUser(String username);

    boolean userExists(String username);

    Set<Authority> getAuthorities(String username);
    void addAuthority(String username, String authority);
    void removeAuthority(String username, String authority);

}