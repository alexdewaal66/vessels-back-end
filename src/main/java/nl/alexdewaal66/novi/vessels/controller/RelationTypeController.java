package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import nl.alexdewaal66.novi.vessels.service.RelationTypeService;
import nl.alexdewaal66.novi.vessels.service.RelationTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/relationtypes")
@CrossOrigin(origins = "*")
public class RelationTypeController extends GenericController<RelationType> {

    @Autowired
    private RelationTypeServiceImpl service;

    public RelationTypeController(GenericServiceImpl<RelationType> service) {
        super(service);
    }

//    @PostMapping(value = "/summaries")
//    public ResponseEntity<Object> getSummariesByIds(@RequestBody List<Long> ids) {
////        System.out.println("GenericController » getSummariesByIds \n\t ids=" + ids);
//        return ResponseEntity.ok().body(service.getSummariesByIds(ids));
//    }

}
