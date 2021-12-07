package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Vessel;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class VesselServiceImpl
        extends GenericServiceImpl<Vessel>
        implements GenericService<Vessel> {

    public VesselServiceImpl(GenericRepository<Vessel> repository) {
        super(repository);
    }
}
