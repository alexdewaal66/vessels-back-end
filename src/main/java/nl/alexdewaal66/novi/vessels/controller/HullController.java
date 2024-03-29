package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Hull;
import nl.alexdewaal66.novi.vessels.service.HullServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hulls")
@CrossOrigin(origins = "*")
public class HullController extends GenericController<Hull> {

    public HullController(HullServiceImpl service) {
        super(service);
    }
}
