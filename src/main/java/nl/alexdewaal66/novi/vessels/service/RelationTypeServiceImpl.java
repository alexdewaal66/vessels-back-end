package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import org.springframework.stereotype.Service;

@Service
public class RelationTypeServiceImpl
        extends GenericServiceImpl<RelationType>
        implements RelationTypeService {

    public RelationTypeServiceImpl(GenericRepository<RelationType> repository) {
        super(repository);
    }
}
