package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Hull;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class HullServiceImpl
        extends GenericServiceImpl<Hull>
        implements GenericService<Hull> {

    public HullServiceImpl(GenericRepository<Hull> repository) {
        super(repository);
    }
}
