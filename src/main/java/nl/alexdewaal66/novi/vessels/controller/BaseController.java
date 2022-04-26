package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
public class BaseController {

    @GetMapping(value = "/")
    public String hello() {
        return "Hello World";
    }

}
