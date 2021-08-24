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

    public Collection<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountry(long id) {
        return countryRepository.findById(id);
    }

    public Country getCountryByName(String nameEN, String nameNL) {
        return countryRepository.findByShortNameENContainsOrShortNameNLContains(nameEN, nameNL);
    }

    public Country getCountryByCode(String alpha2Code, String alpha3Code, String numericCode) {
        return countryRepository.findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
                alpha2Code, alpha3Code, numericCode);
    }
}
