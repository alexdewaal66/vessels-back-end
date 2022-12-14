package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.PropulsionType;
import nl.alexdewaal66.novi.vessels.repository.PropulsionTypeRepository;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.stereotype.Service;

@Service
public class PropulsionTypeServiceImpl
extends GenericServiceImpl<PropulsionType>
implements PropulsionTypeService {

    public PropulsionTypeServiceImpl(GenericRepository<PropulsionType> repository, PropulsionTypeRepository propulsionTypeRepository, AuthorizationHelper authorizationHelper) {
        super(repository, "PropulsionType");
        this.authorizationHelper = authorizationHelper;
    }

    final AuthorizationHelper authorizationHelper;


    @Override
    public Long create(PropulsionType item) {
        Long superTypeId = item.getSuperType().getId();
        PropulsionType superType = repository.getOne(superTypeId);
        item.setSuperType(superType);
        return super.create(item);
    }

}
