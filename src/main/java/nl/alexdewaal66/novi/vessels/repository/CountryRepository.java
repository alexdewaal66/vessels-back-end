package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
            String alpha2Code,
            String alpha3Code,
            String numericCode);

    Country findByShortNameEnContainsOrShortNameNlContains(String nameEN, String nameNL);
}
