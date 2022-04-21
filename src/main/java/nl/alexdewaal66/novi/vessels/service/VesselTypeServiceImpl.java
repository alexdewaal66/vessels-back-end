package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.repository.VesselTypeRepository;
import nl.alexdewaal66.novi.vessels.utils.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@Service
public class VesselTypeServiceImpl
        extends GenericServiceImpl<VesselType>
        implements VesselTypeService{

    public VesselTypeServiceImpl(VesselTypeRepository repository) {
        super(repository);
    }

    @Autowired
    private VesselTypeRepository vesselTypeRepository;

    @Autowired
    private Authorization authorization;


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

    @Override
    public Object update(Long id, VesselType newItem) {
        if (id != 1L || authorization.checkRole("ADMIN")) {
            return super.update(id, newItem);
        } else {
//            logv("VesselTypeServiceImpl.java » update() REJECTED", "id=" + id);
            throw new BadRequestException("Can't update VesselType record #1");
        }
    }

}
