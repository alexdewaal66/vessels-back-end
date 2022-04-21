package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.PropulsionType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/propulsiontypes")
@CrossOrigin(origins = "*")
public class PropulsionTypeController extends GenericController<PropulsionType> {

    public PropulsionTypeController(GenericServiceImpl<PropulsionType> service) {
        super(service);
    }
}
