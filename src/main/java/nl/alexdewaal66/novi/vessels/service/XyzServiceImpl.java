package nl.alexdewaal66.novi.vessels.service;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.repository.XyzRepository;
import org.springframework.stereotype.Service;

@Service
public class XyzServiceImpl extends GenericServiceImpl<Xyz> implements GenericService<Xyz> {

    public XyzServiceImpl(XyzRepository repository) {
        super(repository);
    }
}
/*

 */