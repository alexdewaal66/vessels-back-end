package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Enduser;
import nl.alexdewaal66.novi.vessels.service.EnduserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/signup")
@CrossOrigin(origins = "*")
public class SignUpController {

    final
    EnduserService enduserService;

    final
    PasswordEncoder passwordEncoder;

    public SignUpController(EnduserService enduserService, PasswordEncoder passwordEncoder) {
        this.enduserService = enduserService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> signup(@RequestBody Enduser item) {
//        logv("SignUpController » create()", "user=" + item);
        item.setPassword(passwordEncoder.encode(item.getPassword()));
//        item.setOwner("system");
        Long newId = enduserService.create(item);
//        logv("SignUpController » create()", "id=" + newId);
        return new ResponseEntity<>(String.format("%s %d created", item.getClass().getSimpleName(), newId), HttpStatus.CREATED);
    }
}
