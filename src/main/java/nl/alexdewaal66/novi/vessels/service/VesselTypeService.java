package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.VesselType;

import java.util.Collection;
import java.util.Optional;

public interface VesselTypeService {

    public abstract Collection<VesselType> getVesselTypes();
    public abstract Optional<VesselType> getVesselType(long id);
    public abstract VesselType getVesselTypeByName(String nameEn, String nameNl);
}
