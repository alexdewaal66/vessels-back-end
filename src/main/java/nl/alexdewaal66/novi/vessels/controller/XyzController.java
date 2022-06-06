package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.service.XyzService;
import nl.alexdewaal66.novi.vessels.service.XyzServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/xyzs")
@CrossOrigin(origins = "*")
public class XyzController extends GenericController<Xyz> {

    @Autowired
    private XyzService xyzService;

    public XyzController(XyzServiceImpl service) {
        super(service);
    }

}
