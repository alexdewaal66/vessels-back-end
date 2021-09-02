package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Collection<Long> getAllIds() {
        return countryRepository.getAllIds();
    }

    public Collection<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountry(long id) {
        return countryRepository.findById(id);
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
