package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/countries")
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin(origins = "*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET=READ
    @GetMapping(value = "")
    public ResponseEntity<Object> getCountries() {
        return ResponseEntity.ok().body(countryService.getCountries());
    }

    // GET=READ
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCountry(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(countryService.getCountry(id));
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> getCountryByName(
            @RequestParam(required = false, name = "name_en") String nameEN,
            @RequestParam(required = false, name = "name_nl") String nameNL) {
        return ResponseEntity.ok().body(countryService.getCountryByName(nameEN, nameNL));
    }
}
