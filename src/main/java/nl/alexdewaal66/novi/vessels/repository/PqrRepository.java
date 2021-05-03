package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Pqr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PqrRepository extends JpaRepository<Pqr, Long> {

    Pqr findByPqrStringIgnoreCase(String PqrString);

    Pqr findByPqrStringContainsOrNameContainsOrDescriptionContains(
            String PqrString, String name, String description);
}
