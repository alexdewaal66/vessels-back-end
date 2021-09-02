package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.alexdewaal66.novi.vessels.service.SubdivisionService;

@RestController
@RequestMapping(value = "/subdivisions")
@CrossOrigin(origins = "*")
public class SubdivisionController {

    @Autowired
    private SubdivisionService subdivisionService;

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getSubdivisionIds() {
        return ResponseEntity.ok().body(subdivisionService.getAllIds());
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getSubdivisions() {
        return ResponseEntity.ok().body(subdivisionService.getSubdivisions());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getSubdivision(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(subdivisionService.getSubdivisionById(id));
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> getSubdivisionByCodes(
            @RequestParam(name = "alpha2code") String alpha2Code,
            @RequestParam(name = "subCode") String subCode) {
        return ResponseEntity.ok().body(subdivisionService
                .getSubdivisionByCodes(alpha2Code, subCode)
        );
    }

}

/*
    @GetMapping(value = "/find")
    public ResponseEntity<Object> getCountryByName(
            @RequestParam(required = false, name = "name_en") String nameEN,
            @RequestParam(required = false, name = "name_nl") String nameNL) {
        return ResponseEntity.ok().body(countryService.getCountryByName(nameEN, nameNL));
    }

 */