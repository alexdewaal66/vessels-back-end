package nl.alexdewaal66.novi.vessels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.alexdewaal66.novi.vessels.model.UNLocode;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UNLocodeRepository extends JpaRepository<UNLocode, Long> {

    UNLocode findByAlpha2CodeAndLocationCode(String alpha2Code, String locationCode);

    UNLocode findByNameDiacriticsContainsOrNameWoDiacriticsContains(String name, String nameWo);

    @Query(value = "SELECT u.id FROM un_locode u", nativeQuery = true)
    Collection<Long> getAllIds();

}
