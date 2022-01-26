package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.model.SubdivisionSummary;

import java.util.Collection;

public interface SubdivisionRepository extends GenericRepository<Subdivision> {

    Subdivision findByAlpha2CodeAndSubdivisionCode(String alpha2Code, String subdivisionCode);

    Subdivision findByNameContains(String name);

    Collection<SubdivisionSummary> findAllSummariesBy();

    Collection<SubdivisionSummary> findSummariesByIdIn(Collection<Long> ids);

}
