package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl
        extends GenericServiceImpl<Operation>
        implements OperationService {

    public OperationServiceImpl(GenericRepository<Operation> repository) {
        super(repository, "Operation");
    }
}
