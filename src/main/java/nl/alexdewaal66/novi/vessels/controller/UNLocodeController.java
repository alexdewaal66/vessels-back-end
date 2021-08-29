package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.alexdewaal66.novi.vessels.service.UNLocodeService;

@RestController
@RequestMapping(value = "/un_locode")
@CrossOrigin(origins = "*")
public class UNLocodeController {

    @Autowired
    private UNLocodeService unLocodeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getUNLocodes() {
        return ResponseEntity.ok().body(unLocodeService.getUNLocodes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUNLocode(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(unLocodeService.getUNLocodeById(id));
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> getUNLocodeByCodes(
            @RequestParam(name = "alpha2code") String alpha2Code,
            @RequestParam(name = "locationcode") String locationCode) {
        return ResponseEntity.ok().body(unLocodeService
                .getUNLocodeByCodes(alpha2Code, locationCode)
        );
    }

}
