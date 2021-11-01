package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country;

public interface CountryService extends GenericService<Country> {


    Country getCountryByName(String name);

    Country getCountryByCode(String code);

    Country findCountry(String code, String name);

}
