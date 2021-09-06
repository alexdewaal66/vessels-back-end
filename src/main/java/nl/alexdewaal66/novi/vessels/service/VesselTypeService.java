package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.model.Xyz;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface VesselTypeService {

    Collection<Long> getAllIds();
    Collection<VesselType> getVesselTypes();

    List<VesselType> getByIds(List<Long> ids);

    Optional<VesselType> getVesselTypeById(long id);
    VesselType getVesselTypeByName(String nameEN, String nameNL);

    long createVesselType(VesselType vesselType);

    void updateVesselType(long id, VesselType vesselType);

    void deleteVesselType(long id);

    boolean vesselTypeExists(long id);

}
