package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Relation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/relations")
@CrossOrigin(origins = "*")
public class RelationController extends GenericController<Relation> {
    public RelationController(GenericServiceImpl<Relation> service) {
        super(service);
    }
}
