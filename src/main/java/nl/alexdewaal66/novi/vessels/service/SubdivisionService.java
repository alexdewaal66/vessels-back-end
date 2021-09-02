package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import nl.alexdewaal66.novi.vessels.model.Subdivision;

public interface SubdivisionService {

    Collection<Long> getAllIds();
    Collection<Subdivision> getSubdivisions();
    Subdivision getSubdivisionById(long id);
    Subdivision getSubdivisionByCodes(String alpha2Code, String subCode);

    boolean subdivisionExists(long id);

}
