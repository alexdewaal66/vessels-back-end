package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
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
    public Collection<Long> getAllIds() {
        return vesselTypeRepository.getAllIds();
    }

    @Override
    public Collection<VesselType> getVesselTypes() {
        return vesselTypeRepository.findAll();
    }

    @Override
    public Optional<VesselType> getVesselTypeById(long id) {
        return vesselTypeRepository.findById(id);
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
    public long createVesselType(VesselType vesselType) {
        vesselType.setId(0);
        VesselType newVesselType = vesselTypeRepository.save(vesselType);
        return newVesselType.getId();
    }

    @Override
    public void updateVesselType(long id, VesselType newVesselType) {
        if (vesselTypeExists(id)) {
            newVesselType.setId(id);
            //todo: is supertype updated?
            vesselTypeRepository.save(newVesselType);
        } else {
            throw new RecordNotFoundException("VesselType", id);
        }
    }

    @Override
    public void deleteVesselType(long id) {

    }

    @Override
    public boolean vesselTypeExists(long id) {
        return vesselTypeRepository.existsById(id);
    }
}
