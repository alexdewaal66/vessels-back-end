package nl.alexdewaal66.novi.vessels.controller;

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


    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getCountryIds() {
        return ResponseEntity.ok().body(countryService.getAllIds());
    }

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

    @GetMapping(value = "/name")
    public ResponseEntity<Object> getCountryByName(
            @RequestParam(required = true, name = "name") String name) {
        return ResponseEntity.ok().body(countryService.getCountryByName(name));
    }

    @GetMapping(value = "/code")
    public ResponseEntity<Object> getCountryByCode(
            @RequestParam(required = true, name = "code") String code) {
        return ResponseEntity.ok().body(countryService.getCountryByCode(code));
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> findCountry(
            @RequestParam(required = false, name = "code") String code,
            @RequestParam(required = false, name = "name") String name) {
        return ResponseEntity.ok().body(countryService.findCountry(code, name));
    }

}
