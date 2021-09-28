package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Country;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.alexdewaal66.novi.vessels.service.SubdivisionService;

import java.util.List;

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

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getSubdivisionsByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(subdivisionService.getByIds(ids));
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
    public ResponseEntity<Object> findSubdivision(
            @RequestParam(name = "alpha2code") String alpha2Code,
            @RequestParam(name = "subcode") String subdivisionCode) {
        System.out.println("❌ alpha2Code=" + alpha2Code + ", subdivisionCode=" + subdivisionCode);
        return ResponseEntity.ok().body(subdivisionService
                .findSubdivision(alpha2Code, subdivisionCode)
        );
    }
    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--
    @PostMapping(value = "/findall")
    public ResponseEntity<Object> findSubdivisionsByExample(@RequestBody Match<Subdivision> match) {
        List<Subdivision> subdivisions = subdivisionService.findSubdivisionsByExample(match);
        return ResponseEntity.ok().body(subdivisions);
    }

    @PostMapping(value = "/findone")
    public ResponseEntity<Object> findSubdivisionByExample(@RequestBody Match<Subdivision> match) {
//        System.out.println("SubdivisionController » findSubdivisionByExample \n\tprobe=" + match.getProbe().toString());
        Subdivision subdivision = subdivisionService.findSubdivisionByExample(match)
                .orElse(fallbackSubdivision());
        return ResponseEntity.ok().body(subdivision);
    }

    Subdivision fallbackSubdivision() {
        Subdivision fallback = new Subdivision();
        fallback.setId(-1L);
        fallback.setAlpha2Code("--");
        fallback.setSubdivisionCode("---");
        fallback.setName("fallback-shortnameEN");
        return fallback;
    }
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

}

/*

 */