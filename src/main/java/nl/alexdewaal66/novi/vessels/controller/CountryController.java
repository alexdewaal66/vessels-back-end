package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.service.CountryService;
import nl.alexdewaal66.novi.vessels.service.CountryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/countries")
@CrossOrigin(origins = "*")
public class CountryController extends GenericController<Country> {

    final
    CountryService countryService;

    public CountryController(CountryServiceImpl service, CountryService countryService) {
        super(service);
        this.countryService = countryService;
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> findCountry(
            @RequestParam(required = false, name = "code") String code,
            @RequestParam(required = false, name = "name") String name) {
        return ResponseEntity.ok().body(countryService.findCountry(code, name));
    }
}