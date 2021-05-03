package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Stu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepository extends JpaRepository<Stu, Long> {

    Stu findByStuStringIgnoreCase(String stuString);

    Stu findByStuStringContainsOrNameContainsOrDescriptionContains(
            String stuString, String name, String description);
}
