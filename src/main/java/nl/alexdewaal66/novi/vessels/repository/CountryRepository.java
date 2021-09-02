package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
            String alpha2Code,
            String alpha3Code,
            String numericCode);

    Country findByShortNameENContainsOrShortNameNLContains(String nameEN, String nameNL);

    @Query(value = "SELECT c.id FROM country c", nativeQuery = true)
    Collection<Long> getAllIds();

}
