package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.model.EnduserRestricted;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
import nl.alexdewaal66.novi.vessels.service.EnduserServiceImpl;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class EnduserController extends GenericController<Enduser> {

    private final EnduserService enduserService;

    private final AuthorizationHelper authorizationHelper;


    public EnduserController(EnduserServiceImpl service, EnduserService enduserService, AuthorizationHelper authorizationHelper) {
        super(service);
        this.enduserService = enduserService;
        this.authorizationHelper = authorizationHelper;
    }


    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        UserDetails userDetails = enduserService.loadUserByUsername(username);
        if (authorizationHelper.hasCompleteAccess(username)) {
            return ResponseEntity.ok().body(userDetails);
        } else {
            Long userId = ((Enduser) userDetails).getId();
            return ResponseEntity.ok().body(enduserService.getRestricted(userId));
        }
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        EnduserRestricted restricted = enduserService.getRestricted(id);
        String subjectName = restricted.getUsername();
        if (authorizationHelper.hasCompleteAccess(subjectName)) {
            return ResponseEntity.ok().body(enduserService.getById(id));
        } else {
            return ResponseEntity.ok().body(restricted);
        }
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

    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signup(@RequestBody Enduser item) {
        logv("EnduserController » signup()", "item=" + item);
        return super.create(item);
    }

}
