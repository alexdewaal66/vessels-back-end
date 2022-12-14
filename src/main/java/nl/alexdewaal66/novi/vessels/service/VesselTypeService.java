package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericService;
import nl.alexdewaal66.novi.vessels.model.VesselType;

public interface VesselTypeService extends GenericService<VesselType> {

    VesselType getVesselTypeByName(String nameEN, String nameNL);

}
