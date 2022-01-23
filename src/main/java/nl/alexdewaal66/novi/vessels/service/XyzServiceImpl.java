package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics2.GenericServiceImpl2;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.repository.XyzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XyzServiceImpl
        extends GenericServiceImpl2<Xyz>
        implements XyzService {

//    @Autowired
//    private XyzRepository xyzRepository;

    public XyzServiceImpl(XyzRepository repository) {
        super(repository);
    }

}
