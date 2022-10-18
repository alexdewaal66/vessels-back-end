package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
import nl.alexdewaal66.novi.vessels.service.RoleService;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class EnduserController extends GenericController<Enduser> {

    @Autowired
    EnduserService enduserService;

    @Autowired
    private AuthorizationHelper authorizationHelper;


    public EnduserController(EnduserService service) {
        super((GenericServiceImpl<Enduser>) service);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(enduserService.loadUserByUsername(username));
    }

    @Override
    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        logv("EnduserController » getAll()");
        if (authorizationHelper.checkRole(Role.Roles.ADMIN.label)) {
            return ResponseEntity.ok().body(enduserService.getAll());
        } else {
            return ResponseEntity.ok().body(enduserService.getAllRestricted());
        }
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        String subjectName = enduserService.getById(id).getUsername();
        if (authorizationHelper.isEligible(subjectName)) {
            return ResponseEntity.ok().body(enduserService.getComplete(id));
        } else {
            return ResponseEntity.ok().body(enduserService.getRestricted(id));
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody Enduser item) {
//        Long newId = enduserService.create(item);
//        return new ResponseEntity<>(String.format("%s %d created", item.getClass().getSimpleName(), newId), HttpStatus.CREATED);
        return super.create(item);
    }

}

/**************************************************
 public class UserController {

@Autowired private UserService userService;

MessageList messages = new MessageList();

@PostMapping(value = "")
public ResponseEntity<Object> createUser(@Valid() @RequestBody EndUser endUser) {
System.out.println("» UserController - CreateUser: " + endUser.toString());
String newUsername = userService.createUser(endUser);
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
public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody EndUser endUser) {
userService.updateUser(username, endUser);
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
 ************************************************************************************/
