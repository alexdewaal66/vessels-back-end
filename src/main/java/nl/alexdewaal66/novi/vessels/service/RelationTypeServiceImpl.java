package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.RelationType;
import nl.alexdewaal66.novi.vessels.repository.RelationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationTypeServiceImpl
        extends GenericServiceImpl<RelationType>
        implements RelationTypeService {

        @Autowired
    private RelationTypeRepository relationTypeRepository;

    public RelationTypeServiceImpl(RelationTypeRepository repository) {
        super(repository);
    }

//    public Collection<RelationTypeSummary> getSummariesByIds(List<Long> ids) {
//        return relationTypeRepository.findAllById(ids);
//    }
}
