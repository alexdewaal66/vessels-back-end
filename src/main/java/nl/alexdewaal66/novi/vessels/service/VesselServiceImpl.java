package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Vessel;
import nl.alexdewaal66.novi.vessels.repository.VesselRepository;
import org.springframework.stereotype.Service;

@Service
public class VesselServiceImpl
        extends GenericServiceImpl<Vessel>
        implements VesselService {

    public VesselServiceImpl(VesselRepository repository) {
        super(repository, "Vessel");
    }

}
