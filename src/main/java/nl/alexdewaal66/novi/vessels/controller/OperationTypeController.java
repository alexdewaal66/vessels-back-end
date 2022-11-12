package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.OperationType;
import nl.alexdewaal66.novi.vessels.service.OperationTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/operationtypes")
@CrossOrigin(origins = "*")
public class OperationTypeController extends GenericController<OperationType> {

    public OperationTypeController(OperationTypeServiceImpl service) {
        super(service);
    }
}
