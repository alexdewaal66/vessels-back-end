package nl.alexdewaal66.novi.vessels.repository;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZyxRepository extends JpaRepository<Zyx, Long> {
    Zyx findByName(String name);
}
