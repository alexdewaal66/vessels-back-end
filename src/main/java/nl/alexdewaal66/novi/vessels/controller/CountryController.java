package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.service.CountryService;
import nl.alexdewaal66.novi.vessels.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/countries")
@CrossOrigin(origins = "*")
public class CountryController extends GenericController<Country> {

    @Autowired
    CountryService countryService;

    public CountryController(GenericServiceImpl<Country> service) {
        super(service);
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