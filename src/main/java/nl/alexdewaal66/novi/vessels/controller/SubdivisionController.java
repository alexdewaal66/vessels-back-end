package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
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
public class SubdivisionController extends GenericController<Subdivision> {

    @Autowired
    private SubdivisionService subdivisionService;
    public SubdivisionController(GenericServiceImpl<Subdivision> service) {
        super(service);
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

}
