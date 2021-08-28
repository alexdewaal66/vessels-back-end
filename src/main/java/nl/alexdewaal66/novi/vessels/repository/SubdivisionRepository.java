package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {

    Subdivision findByAlpha2CodeAndCode(String alpha2Code, String code);

    Subdivision findByNameContains(String name);

}
