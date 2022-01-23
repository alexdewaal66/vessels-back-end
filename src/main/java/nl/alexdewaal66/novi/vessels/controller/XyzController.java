package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics2.GenericController2;
import nl.alexdewaal66.novi.vessels.service.XyzService;
import nl.alexdewaal66.novi.vessels.service.XyzServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/xyzs")
@CrossOrigin(origins = "*")
public class XyzController extends GenericController2<Xyz> {

    @Autowired
    private XyzService xyzService;

    public XyzController(XyzServiceImpl service) {
        super(service);
    }

//    @GetMapping(value = "/summaries")
//    public ResponseEntity<Object> getSummaries() {
//        return ResponseEntity.ok().body(xyzService.getAllSummaries());
//    }

}
