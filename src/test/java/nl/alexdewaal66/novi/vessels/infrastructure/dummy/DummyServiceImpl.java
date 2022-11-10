package nl.alexdewaal66.novi.vessels.infrastructure.dummy;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import org.springframework.stereotype.Service;

/////// dummy service implementation for testing purposes //////////////
@Service
public class DummyServiceImpl
        extends GenericServiceImpl<Dummy>
        implements DummyService {

    public DummyServiceImpl(DummyRepository repository) {
        super(repository, "Dummy");
    }
}
