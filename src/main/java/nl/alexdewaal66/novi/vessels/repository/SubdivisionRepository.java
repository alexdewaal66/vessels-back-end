package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

    Subdivision findByAlpha2CodeAndSubdivisionCode(String alpha2Code, String subdivisionCode);

    Subdivision findByNameContains(String name);

//    @Query(value = "SELECT s.id FROM subdivision s", nativeQuery = true)
//    Collection<Long> getAllIds();

    Collection<ProjectId> findAllBy();
}
