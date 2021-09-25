package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import nl.alexdewaal66.novi.vessels.model.ProjectId;
import nl.alexdewaal66.novi.vessels.utils.Match;


public interface CountryService {

    Collection<ProjectId> getAllIds();
    Collection<Country> getCountries();

    List<Country> getByIds(List<Long> ids);

    Optional<Country> getCountry(long id);

    Country getCountryByName(String name);

    Country getCountryByCode(String code);

    Country findCountry(String code, String name);

    Optional<Country> findCountryByExample(Match<Country>  match);

    List<Country> findCountriesByExample(Match<Country>  match);
}
