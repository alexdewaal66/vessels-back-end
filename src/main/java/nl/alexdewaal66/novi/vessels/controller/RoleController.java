package nl.alexdewaal66.novi.vessels.controller;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Role;
import nl.alexdewaal66.novi.vessels.service.RoleServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles")
@CrossOrigin(origins = "*")
public class RoleController extends GenericController<Role> {
    public RoleController(RoleServiceImpl service) {
        super(service);
    }
}
