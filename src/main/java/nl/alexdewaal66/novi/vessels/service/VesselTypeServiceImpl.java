package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import nl.alexdewaal66.novi.vessels.repository.VesselTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class VesselTypeServiceImpl extends GenericServiceImpl<VesselType>  implements VesselTypeService{

    @Autowired
    private VesselTypeRepository vesselTypeRepository;

    public VesselTypeServiceImpl(GenericRepository<VesselType> repository) {
        super(repository);
    }

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
            System.out.println("» VesselTypeServiceImpl » create() *before* getId(), *before* getOne()"
                + "\n\t item=" + item.toString());
        Long superTypeId = item.getSuperType().getId();
            System.out.println("» VesselTypeServiceImpl » create() *after* getId(), *before* getOne()"
                + "\n\t superTypeId = " + superTypeId);
        VesselType superType = vesselTypeRepository.getOne(superTypeId);
            System.out.println("» VesselTypeServiceImpl » create() *after* getId(), *after* getOne()"
                + "\n\t superType = " + superType);
        item.setSuperType(superType);
            System.out.println("» VesselTypeServiceImpl » create() *after* setSuperType()"
                + "\n\t item=" + item.toString());
        return super.create(item);
    }

}
