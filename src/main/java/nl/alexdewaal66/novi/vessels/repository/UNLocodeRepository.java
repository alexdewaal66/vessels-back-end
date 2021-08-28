package nl.alexdewaal66.novi.vessels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.alexdewaal66.novi.vessels.model.UNLocode;

public interface UNLocodeRepository extends JpaRepository<UNLocode, Long> {

    UNLocode findByAlpha2CodeAndLocationCode(String alpha2Code, String locationCode);

    UNLocode findByNameDiacriticsContainsOrNameWoDiacriticsContains(String name);

}
