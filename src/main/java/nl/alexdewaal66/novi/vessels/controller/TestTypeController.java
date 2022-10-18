package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.service.TestTypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.TestType;

@RestController
@RequestMapping(value = "/testtypes")
@CrossOrigin(origins = "*")
public class TestTypeController extends GenericController<TestType> {

    public TestTypeController(TestTypeServiceImpl service) {
        super(service);
    }

}
