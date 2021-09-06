package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.model.Xyz;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CountryService {

    Collection<Long> getAllIds();
    Collection<Country> getCountries();

    List<Country> getByIds(List<Long> ids);

    Optional<Country> getCountry(long id);

    Country getCountryByName(String name);

    Country getCountryByCode(String code);

    Country findCountry(String code, String name);

}
