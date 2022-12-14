package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import nl.alexdewaal66.novi.vessels.service.RelationTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/relationtypes")
@CrossOrigin(origins = "*")
public class RelationTypeController extends GenericController<RelationType> {

    final RelationTypeServiceImpl relationTypeService;

    public RelationTypeController(GenericServiceImpl<RelationType> service, RelationTypeServiceImpl relationTypeService) {
        super(service);
        this.relationTypeService = relationTypeService;
    }

}
