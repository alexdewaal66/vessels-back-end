package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.model.Organisation;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/organisations")
@CrossOrigin(origins = "*")
public class OrganisationController extends GenericController<Organisation> {
    public OrganisationController(GenericServiceImpl<Organisation> service) {
        super(service);
    }
}
