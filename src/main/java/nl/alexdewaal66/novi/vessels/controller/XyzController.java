package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.service.XyzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/xyzs")
public class XyzController {

    @Autowired
    private XyzService xyzService;

    // POST=CREATE
    @PostMapping(value = "")
    public ResponseEntity<Object> createXyz(@RequestBody Xyz xyz) {
//        long newId = xyzService.createXyz(xyz);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{xyzString}")
//                .buildAndExpand(newId).toUri();
//
//        return ResponseEntity.created(location).build();
        long newId = xyzService.createXyz(xyz);
        return new ResponseEntity<>(String.format("Xyz %d created", newId), HttpStatus.CREATED);
    }

    // GET=READ
    @GetMapping(value = "")
    public ResponseEntity<Object> getXyzs() {
        return ResponseEntity.ok().body(xyzService.getXyzs());
    }

    // GET=READ
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getXyz(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(xyzService.getXyzById(id));
    }

    // PUT=UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateXyz(@PathVariable("id") long id,
                                            @RequestBody Xyz xyz) {
        xyzService.updateXyz(id, xyz);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteXyz(@PathVariable("id") long id) {
        xyzService.deleteXyz(id);
        return ResponseEntity.noContent().build();
    }
}
