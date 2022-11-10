package nl.alexdewaal66.novi.vessels.infrastructure.dummy;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/////// dummy controller for testing purposes //////////////

@RestController
@RequestMapping(value = "/dummies")
@CrossOrigin(origins = "*")
public class DummyController extends GenericController<Dummy> {

    public DummyController(DummyServiceImpl service) {super(service);}

}
