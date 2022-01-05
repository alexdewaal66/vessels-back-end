package nl.alexdewaal66.novi.vessels.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.generics.ProjectId;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.utils.Match;

public interface SubdivisionService extends GenericService<Subdivision> {





    Subdivision findSubdivision(String alpha2Code, String subdivisionCode);


//    Optional<Subdivision> findSubdivisionByExample(Match<Subdivision> match);

//    List<Subdivision> findSubdivisionsByExample(Match<Subdivision>  match);

}
/*

 */