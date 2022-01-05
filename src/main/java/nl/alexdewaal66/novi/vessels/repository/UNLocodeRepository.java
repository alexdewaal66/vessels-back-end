package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import nl.alexdewaal66.novi.vessels.model.UNLocode;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UNLocodeRepository extends GenericRepository<UNLocode> {

    UNLocode findByAlpha2CodeAndLocationCode(String alpha2Code, String locationCode);

    UNLocode findByNameDiacriticsContainsOrNameWoDiacriticsContains(String name, String nameWo);

}
