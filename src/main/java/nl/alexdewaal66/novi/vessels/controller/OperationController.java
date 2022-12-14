package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Operation;
import nl.alexdewaal66.novi.vessels.service.OperationServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/operations")
@CrossOrigin(origins = "*")
public class OperationController extends GenericController<Operation> {

    public OperationController(OperationServiceImpl service) {
        super(service);
    }
}
