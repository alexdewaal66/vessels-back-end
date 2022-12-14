package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.OperationType;
import org.springframework.stereotype.Service;

@Service
public class OperationTypeServiceImpl
        extends GenericServiceImpl<OperationType>
        implements OperationTypeService {

    public OperationTypeServiceImpl(GenericRepository<OperationType> repository) {
        super(repository, "OperationType");
    }
}
