package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import nl.alexdewaal66.novi.vessels.repository.RelationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationTypeServiceImpl
        extends GenericServiceImpl<RelationType>
        implements RelationTypeService {

    private final RelationTypeRepository relationTypeRepository;

    public RelationTypeServiceImpl(RelationTypeRepository repository, RelationTypeRepository relationTypeRepository) {
        super(repository, "RelationType");
        this.relationTypeRepository = relationTypeRepository;
    }

}
