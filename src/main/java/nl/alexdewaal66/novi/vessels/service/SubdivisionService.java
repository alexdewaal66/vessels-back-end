package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import nl.alexdewaal66.novi.vessels.model.Subdivision;

public interface SubdivisionService {
    Collection<Subdivision> getSubdivisions();
    Subdivision getSubdivisionById(long id);
    Subdivision getSubdivisionByCodes(String alpha2Code, String code);

    boolean subdivisionExists(long id);

}
