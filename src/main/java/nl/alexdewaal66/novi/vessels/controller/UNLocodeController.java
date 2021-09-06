package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.service.UNLocodeService;

import java.util.List;

@RestController
@RequestMapping(value = "/un_locode")
@CrossOrigin(origins = "*")
public class UNLocodeController {

    @Autowired
    private UNLocodeService unLocodeService;

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getUNLocodeIds() {
        return ResponseEntity.ok().body(unLocodeService.getAllIds());
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getUNLocodes() {
        return ResponseEntity.ok().body(unLocodeService.getUNLocodes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUNLocode(@PathVariable("id") long id) {
        UNLocode unLocode = unLocodeService.getUNLocodeById(id);
        return ResponseEntity.ok().body(unLocode);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> getUNLocodeByCodes(
            @RequestParam(name = "alpha2code") String alpha2Code,
            @RequestParam(name = "locationcode") String locationCode) {
        return ResponseEntity.ok().body(unLocodeService
                .getUNLocodeByCodes(alpha2Code, locationCode)
        );
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getUNLocodesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(unLocodeService.getByIds(ids));
    }

}
