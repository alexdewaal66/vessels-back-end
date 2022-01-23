package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Relation;
import nl.alexdewaal66.novi.vessels.repository.RelationRepository;
import org.springframework.stereotype.Service;

@Service
public class RelationServiceImpl
        extends GenericServiceImpl<Relation>
        implements RelationService{

    public RelationServiceImpl(RelationRepository repository) {
        super(repository);
    }
}
