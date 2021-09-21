package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getCountriesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(countryService.getByIds(ids));
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
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name) {
        System.out.println("❌ code=" + code + ", name=" + name);
        return ResponseEntity.ok().body(countryService.findCountry(code, name));
    }

    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
    @PostMapping(value = "/qbe")
    public ResponseEntity<Object> findCountryByExample(@RequestBody Country probe) {
//        System.out.println("» CountryController » getCountryByExample \n\tprobe=" + probe.toString());
        Country country = countryService.findCountryByExample(probe).orElse(fallbackCountry());
//        System.out.println("» CountryController » getCountryByExample \n\tcountry=" + country.toString());
        return ResponseEntity.ok().body(country);
    }
    Country fallbackCountry() {
        Country fallback = new Country();
        fallback.setId(-1L);
        fallback.setAlpha2Code("--");
        fallback.setAlpha3Code("---");
        fallback.setNumericCode("000");
        fallback.setShortNameEN("fallback-shortnameEN");
        fallback.setShortNameNL("fallback-shortnameNL");
        return fallback;
    }
    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

}
