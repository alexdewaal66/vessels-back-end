package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import nl.alexdewaal66.novi.vessels.model.ProjectId;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.utils.Match;

public interface SubdivisionService {

    Collection<ProjectId> getAllIds();
    Collection<Subdivision> getSubdivisions();

    List<Subdivision> getByIds(List<Long> ids);

    Subdivision getSubdivisionById(long id);

    Subdivision findSubdivision(String alpha2Code, String subdivisionCode);

    boolean subdivisionExists(long id);

    Optional<Subdivision> findSubdivisionByExample(Match<Subdivision> match);

    List<Subdivision> findSubdivisionsByExample(Match<Subdivision>  match);

}
/*

 */