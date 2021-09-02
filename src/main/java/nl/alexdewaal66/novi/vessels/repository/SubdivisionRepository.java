package nl.alexdewaal66.novi.vessels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

    Subdivision findByAlpha2CodeAndSubCode(String alpha2Code, String subCode);

    Subdivision findByNameContains(String name);

    @Query(value = "SELECT s.id FROM subdivision s", nativeQuery = true)
    Collection<Long> getAllIds();

}
