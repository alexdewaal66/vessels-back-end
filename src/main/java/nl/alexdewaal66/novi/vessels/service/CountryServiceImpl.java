package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.repository.CountryRepository;
import nl.alexdewaal66.novi.vessels.model.ProjectId;
import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import nl.alexdewaal66.novi.vessels.utils.Matcher;

import java.util.*;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Collection<ProjectId> getAllIds() {
        return countryRepository.findAllBy();
    }

    public Collection<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> getByIds(List<Long> ids) {
        return countryRepository.findAllById(ids);
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

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--
    List<String> textProperties = Arrays.asList("shortNameNL", "shortNameEN");

    @Override
    public Optional<Country> findCountryByExample(Match<Country> match) {
        Country probe = match.getProbe();
        String mode = match.getMode();
        Example<Country> example = Example.of(probe, Matcher.build(mode, textProperties));
        return countryRepository.findOne(example);
    }

    @Override
    public List<Country> findCountriesByExample(Match<Country> match) {
        Country probe = match.getProbe();
        String mode = match.getMode();
        Example<Country> example = Example.of(probe, Matcher.build(mode, textProperties));
        return countryRepository.findAll(example);
    }
    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--
//    class FindByExample<T,R> {
//
//        @Autowired
//        R repository;
//        public Optional<T> findOne(Match<T> match) {
//            E probe = match.getProbe();
//            String mode = match.getMode();
//            Example<T> example = Example.of(probe, Matcher.build(mode, properties));
//            return repository.findAll(example);
//        }
//    }
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    public Country getCountryByName(String name) {
        return countryRepository.findByShortNameENContainsOrShortNameNLContains(name, name);
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByAlpha2CodeEqualsOrAlpha3CodeEqualsOrNumericCodeEquals(
                code, code, code);
    }

}
