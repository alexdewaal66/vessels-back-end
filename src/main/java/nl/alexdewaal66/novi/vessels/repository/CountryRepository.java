package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.model.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
            String alpha2Code,
            String alpha3Code,
            String numericCode);

    Country findByShortNameENContainsOrShortNameNLContains(String nameEN, String nameNL);

//    @Query(value = "SELECT c.id FROM country c", nativeQuery = true)
//    Collection<Long> getAllIds();

    Collection<ProjectId> findAllBy();
}


