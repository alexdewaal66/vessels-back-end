package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Country2;
import nl.alexdewaal66.novi.vessels.service.GenericServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/countries2")
@CrossOrigin(origins = "*")
public class Country2Controller extends GenericController<Country2> {

    public Country2Controller(GenericServiceImpl<Country2> service) {
        super(service);
    }
}
