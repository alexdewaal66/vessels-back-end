package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/relationtypes")
@CrossOrigin(origins = "*")
public class RelationTypeController extends GenericController<RelationType> {

    public RelationTypeController(GenericServiceImpl<RelationType> service) {
        super(service);
    }
}
