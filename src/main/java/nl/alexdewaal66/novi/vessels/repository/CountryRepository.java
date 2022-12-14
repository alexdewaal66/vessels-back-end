package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.model.CountrySummary;

import java.util.Collection;

public interface CountryRepository extends GenericRepository<Country> {

    Country findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
            String alpha2Code,
            String alpha3Code,
            String numericCode);

    Country findByShortNameENContainsOrShortNameNLContains(String nameEN, String nameNL);

    Collection<CountrySummary> findAllSummariesBy();

    Collection<CountrySummary> findSummariesByIdIn(Collection<Long> ids);

}
