package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import java.util.List;

import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.model.Xyz;

public interface SubdivisionService {

    Collection<Long> getAllIds();
    Collection<Subdivision> getSubdivisions();

    List<Subdivision> getByIds(List<Long> ids);

    Subdivision getSubdivisionById(long id);

    Subdivision findSubdivision(String alpha2Code, String subdivisionCode);

    boolean subdivisionExists(long id);

}
