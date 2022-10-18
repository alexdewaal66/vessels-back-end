package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.repository.VesselTypeRepository;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@Service
public class VesselTypeServiceImpl
        extends GenericServiceImpl<VesselType>
        implements VesselTypeService{

    public VesselTypeServiceImpl(VesselTypeRepository repository) {
        super(repository, "VesselType");
    }

    @Autowired
    private VesselTypeRepository vesselTypeRepository;

    @Autowired
    private AuthorizationHelper authorizationHelper;


    @Override
    public VesselType getVesselTypeByName(String nameEN, String nameNL) {
        try {
            return vesselTypeRepository.findByNameENContainsOrNameNLContains(nameEN, nameNL);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Long create(VesselType item) {
        Long superTypeId = item.getSuperType().getId();
        VesselType superType = repository.getOne(superTypeId);
        item.setSuperType(superType);
        return super.create(item);
    }


}
