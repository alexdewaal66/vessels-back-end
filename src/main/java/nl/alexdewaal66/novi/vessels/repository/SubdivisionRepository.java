package nl.alexdewaal66.novi.vessels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.alexdewaal66.novi.vessels.model.Subdivision;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

    Subdivision findByAlpha2CodeAndCode(String alpha2Code, String code);

    Subdivision findByNameContains(String name);

}
