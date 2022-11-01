package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Subdivision;
import nl.alexdewaal66.novi.vessels.service.SubdivisionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.alexdewaal66.novi.vessels.service.SubdivisionService;

@RestController
@RequestMapping(value = "/subdivisions")
@CrossOrigin(origins = "*")
public class SubdivisionController extends GenericController<Subdivision> {

    private final SubdivisionService subdivisionService;
    public SubdivisionController(SubdivisionServiceImpl service, SubdivisionService subdivisionService) {
        super(service);
        this.subdivisionService = subdivisionService;
    }


    @GetMapping(value = "/find")
    public ResponseEntity<Object> findSubdivision(
            @RequestParam(name = "alpha2code") String alpha2Code,
            @RequestParam(name = "subcode") String subdivisionCode) {
        return ResponseEntity.ok().body(subdivisionService
                .findSubdivision(alpha2Code, subdivisionCode)
        );
    }

}
