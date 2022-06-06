package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Hull;
import nl.alexdewaal66.novi.vessels.repository.HullRepository;
import org.springframework.stereotype.Service;

@Service
public class HullServiceImpl
        extends GenericServiceImpl<Hull>
        implements HullService {

    public HullServiceImpl(HullRepository repository) {
        super(repository, "Hull");
    }
}
