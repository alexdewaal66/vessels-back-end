package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.model.Subdivision;

public interface SubdivisionService extends GenericService<Subdivision> {

    Subdivision findSubdivision(String alpha2Code, String subdivisionCode);


}
