package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends GenericServiceImpl<Country> implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository repository) {
        super(repository, "Country");
    }


    public Country findCountry(String code, String name) {
        if (code != null) {
            return getCountryByCode(code);
        }
        if (name != null) {
            return getCountryByName(name);
        }
        return null;
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByShortNameENContainsOrShortNameNLContains(name, name);
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
                code, code, code);
    }

}