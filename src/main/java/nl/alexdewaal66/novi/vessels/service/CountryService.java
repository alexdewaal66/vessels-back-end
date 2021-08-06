package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country;

import java.util.Collection;
import java.util.Optional;

public interface CountryService {

    public abstract Collection<Country> getCountries();
    public abstract Optional<Country> getCountry(long id);
    public abstract Country getCountryByName(String nameEN, String nameNL);
    public abstract Country getCountryByCode(String alpha2Code, String alpha3Code, String numericCode);

    }
