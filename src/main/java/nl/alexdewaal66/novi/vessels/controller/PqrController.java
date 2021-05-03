package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Pqr;
import nl.alexdewaal66.novi.vessels.service.PqrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pqrs")
public class PqrController {

    @Autowired
    private PqrService pqrService;

    // POST=CREATE
    @PostMapping(value = "")
    public ResponseEntity<Object> createpqr(@RequestBody Pqr pqr) {
//        long newId = pqrService.createpqr(pqr);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{pqrString}")
//                .buildAndExpand(newId).toUri();
//
//        return ResponseEntity.created(location).build();
        long newId = pqrService.createPqr(pqr);
        return new ResponseEntity<>(String.format("pqr %d created", newId), HttpStatus.CREATED);
    }

    // GET=READ
    @GetMapping(value = "")
    public ResponseEntity<Object> getpqrs() {
        return ResponseEntity.ok().body(pqrService.getPqrs());
    }

    // GET=READ
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getpqr(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(pqrService.getPqrById(id));
    }

    // PUT=UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatepqr(@PathVariable("id") long id,
                                            @RequestBody Pqr pqr) {
        pqrService.updatePqr(id, pqr);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletepqr(@PathVariable("id") long id) {
        pqrService.deletePqr(id);
        return ResponseEntity.noContent().build();
    }
}
