package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.model.Xyz;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface VesselTypeService extends GenericService<VesselType> {

    VesselType getVesselTypeByName(String nameEN, String nameNL);

}
