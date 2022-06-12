package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.exceptions.UsernameNotFoundException;
import nl.alexdewaal66.novi.vessels.exceptions.UsernameExistsException;
import nl.alexdewaal66.novi.vessels.model.Authority;
import nl.alexdewaal66.novi.vessels.model.EndUser;
import nl.alexdewaal66.novi.vessels.model.UserSummary;
import nl.alexdewaal66.novi.vessels.repository.UserRepository;
import nl.alexdewaal66.novi.vessels.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<String> getAllIds() {
        return userRepository.getAllIds();
    }

    @Override
    public Collection<EndUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Collection<UserSummary> getUserSummaries() {
        return userRepository.findAllUserSummariesBy();
    }

    @Override
    public Optional<EndUser> getUser(String username) {
        return userRepository.findById(username);
    }

    @Override
    public List<EndUser> getByIds(List<String> usernames) {
        return  userRepository.findAllById(usernames);
    }


    @Override
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public String createUser(EndUser endUser)
    {
        if (userRepository.existsById(endUser.getUsername())) throw new UsernameExistsException(endUser.getUsername());
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        endUser.setApikey(randomString);
        endUser.setPassword(passwordEncoder.encode(endUser.getPassword()));
        EndUser newEndUser = userRepository.save(endUser);
        return newEndUser.getUsername();
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void updateUser(String username, EndUser newEndUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        EndUser endUser = userRepository.findById(username).get();
        endUser.setPassword(passwordEncoder.encode(endUser.getPassword()));
        userRepository.save(endUser);
    }

    @Override
    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        EndUser endUser = userRepository.findById(username).get();
        return endUser.getAuthorities();
    }

    @Override
    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        EndUser endUser = userRepository.findById(username).get();
        endUser.addAuthority(new Authority(username, authority));
        userRepository.save(endUser);
    }

    @Override
    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        EndUser endUser = userRepository.findById(username).get();
        Authority authorityToRemove = endUser.getAuthorities().stream().filter((a) -> a.getRole().equalsIgnoreCase(authority)).findAny().get();
        endUser.removeAuthority(authorityToRemove);
        userRepository.save(endUser);
    }



}