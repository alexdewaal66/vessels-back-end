package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.model.User;
import nl.alexdewaal66.novi.vessels.service.UserService;
import nl.alexdewaal66.novi.vessels.payload.MessageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    MessageList messages = new MessageList();

    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@Valid() @RequestBody User user) {
        System.out.println("» UserController - CreateUser: " + user.toString());
        String newUsername = userService.createUser(user);
        messages.clear().addMessage("User " + newUsername + " created");

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{username}")
//                .buildAndExpand(newUsername).toUri();
//
//        return ResponseEntity.created(location).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(messages);
    }

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getUserIds() {
        return ResponseEntity.ok().body(userService.getAllIds());
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/summaries")
    public ResponseEntity<Object> getUserSummaries() {
        return ResponseEntity.ok().body(userService.getUserSummaries());
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getUsersByUsernames(@RequestBody List<String> usernames) {
        return ResponseEntity.ok().body(userService.getByIds(usernames));
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user) {
        userService.updateUser(username, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }

}
