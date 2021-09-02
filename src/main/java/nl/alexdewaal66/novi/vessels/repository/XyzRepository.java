package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Xyz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface XyzRepository extends JpaRepository<Xyz, Long> {

    Xyz findByXyzStringIgnoreCase(String xyzString);

    Xyz findByXyzStringContainsOrNameContainsOrDescriptionContains(
            String xyzString, String name, String description);

    @Query(value = "SELECT x.id FROM xyz x", nativeQuery = true)
    Collection<Long> getAllIds();

}
