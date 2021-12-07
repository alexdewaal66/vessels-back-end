package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.model.Address;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/addresses")
@CrossOrigin(origins = "*")
public class AddressController extends GenericController<Address> {
    public AddressController(GenericServiceImpl<Address> service) {
        super(service);
    }
}
