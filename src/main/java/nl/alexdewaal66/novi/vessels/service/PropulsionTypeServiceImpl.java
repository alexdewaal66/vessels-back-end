package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.PropulsionType;
import nl.alexdewaal66.novi.vessels.repository.PropulsionTypeRepository;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@Service
public class PropulsionTypeServiceImpl
extends GenericServiceImpl<PropulsionType>
implements PropulsionTypeService {

    public PropulsionTypeServiceImpl(GenericRepository<PropulsionType> repository) {
        super(repository, "PropulsionType");
    }

    @Autowired
    private PropulsionTypeRepository propulsionTypeRepository;

    @Autowired
    private AuthorizationHelper authorizationHelper;


    @Override
    public Long create(PropulsionType item) {
        Long superTypeId = item.getSuperType().getId();
        PropulsionType superType = repository.getOne(superTypeId);
        item.setSuperType(superType);
        return super.create(item);
    }

}
