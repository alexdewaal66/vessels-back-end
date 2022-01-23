package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.model.Relation;
import nl.alexdewaal66.novi.vessels.service.RelationServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/relations")
@CrossOrigin(origins = "*")
public class RelationController extends GenericController<Relation> {
    public RelationController(RelationServiceImpl service) {
        super(service);
    }
}
