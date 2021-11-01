package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Address;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl
extends GenericServiceImpl<Address>
implements GenericService<Address> {

    public AddressServiceImpl(GenericRepository<Address> repository) {
        super(repository);
    }
}
