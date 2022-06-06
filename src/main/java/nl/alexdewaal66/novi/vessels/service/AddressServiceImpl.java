package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Address;
import nl.alexdewaal66.novi.vessels.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl
        extends GenericServiceImpl<Address>
        implements AddressService {

    public AddressServiceImpl(AddressRepository repository) {
        super(repository, "Address");
    }
}
