package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Subdivision;

public interface SubdivisionRepository extends GenericRepository<Subdivision> {

    Subdivision findByAlpha2CodeAndSubdivisionCode(String alpha2Code, String subdivisionCode);

    Subdivision findByNameContains(String name);
}
