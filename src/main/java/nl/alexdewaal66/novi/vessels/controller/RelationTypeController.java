package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import nl.alexdewaal66.novi.vessels.service.RelationTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/relationtypes")
@CrossOrigin(origins = "*")
public class RelationTypeController extends GenericController<RelationType> {

    private final RelationTypeServiceImpl relationTypeService;

    public RelationTypeController(GenericServiceImpl<RelationType> service, RelationTypeServiceImpl relationTypeService) {
        super(service);
        this.relationTypeService = relationTypeService;
    }

}
