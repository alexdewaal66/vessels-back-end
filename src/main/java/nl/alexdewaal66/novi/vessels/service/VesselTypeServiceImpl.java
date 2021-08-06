package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.repository.VesselTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class VesselTypeServiceImpl implements VesselTypeService{

    @Autowired
    private VesselTypeRepository vesselTypeRepository;

    @Override
    public Collection<VesselType> getVesselTypes() {
        return vesselTypeRepository.findAll();
    }

    @Override
    public Optional<VesselType> getVesselType(long id) {
        return vesselTypeRepository.findById(id);
    }

    @Override
    public VesselType getVesselTypeByName(String nameEn, String nameNl) {
        return vesselTypeRepository.findByNameEnContainsOrNameNlContains(nameEn, nameNl);
    }
}
