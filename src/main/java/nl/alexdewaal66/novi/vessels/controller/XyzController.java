package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.service.XyzService;
import nl.alexdewaal66.novi.vessels.service.XyzServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/xyzs")
@CrossOrigin(origins = "*")
public class XyzController extends GenericController<Xyz> {

    final XyzService xyzService;

    public XyzController(XyzServiceImpl service, XyzService xyzService) {
        super(service);
        this.xyzService = xyzService;
    }

}
