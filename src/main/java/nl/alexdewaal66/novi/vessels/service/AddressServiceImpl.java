package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Address;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl
extends GenericServiceImpl<Address>
implements GenericService<Address> {

    public AddressServiceImpl(GenericRepository<Address> repository) {
        super(repository);
    }
}
