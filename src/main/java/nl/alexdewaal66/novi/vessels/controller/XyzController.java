package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.service.XyzService;

@RestController
@RequestMapping(value = "/xyzs")
@CrossOrigin(origins = "*")
public class XyzController {

    @Autowired
    private XyzService xyzService;

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

    @PostMapping(value = "")
    public ResponseEntity<Object> createXyz(@RequestBody Xyz xyz) {
        System.out.println("» XyzController - CreateXyz: " + xyz.toString());
        long newId = xyzService.createXyz(xyz);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{xyzString}")
//                .buildAndExpand(newId).toUri();
//
//        return ResponseEntity.created(location).build();
        return new ResponseEntity<>(String.format("Xyz %d created", newId), HttpStatus.CREATED);
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
