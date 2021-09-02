package nl.alexdewaal66.novi.vessels.repository;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ZyxRepository extends JpaRepository<Zyx, Long> {
    Zyx findByName(String name);

    @Query(value = "SELECT z.id FROM zyx z", nativeQuery = true)
    Collection<Long> getAllIds();
}
