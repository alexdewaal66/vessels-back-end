package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.repository.XyzRepository;
import org.springframework.stereotype.Service;

@Service
public class XyzServiceImpl
        extends GenericServiceImpl<Xyz>
        implements XyzService {

    public XyzServiceImpl(XyzRepository repository) {
        super(repository, "Xyz");
    }

}
