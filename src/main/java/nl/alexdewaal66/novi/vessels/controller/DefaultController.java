package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = {"*"})
public class DefaultController {

    static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    @GetMapping(value = "/")
    public String hello() {
        Date date = new Date();

        return "This is the default controller for the Vessels back end.<br>Time: " + formatter.format(date);
    }

}
