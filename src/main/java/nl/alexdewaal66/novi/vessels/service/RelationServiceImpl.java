package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Relation;
import org.springframework.stereotype.Service;

@Service
public class RelationServiceImpl
        extends GenericServiceImpl<Relation>
        implements RelationService{

    public RelationServiceImpl(GenericRepository<Relation> repository) {
        super(repository);
    }
}
