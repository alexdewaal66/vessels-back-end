package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.Xyz;

import java.util.List;

@RestController
@RequestMapping(value = "/xyzs")
@CrossOrigin(origins = "*")
public class XyzController {

    @Autowired
    private GenericService<Xyz> xyzService;

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getXyzIds() {
        return ResponseEntity.ok().body(xyzService.getAllIds());
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getXyzs() {
        return ResponseEntity.ok().body(xyzService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getXyz(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(xyzService.getById(id));
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getXyzsByIds(@RequestBody List<Long> ids) {
        System.out.println("XyzController » getXyzsByIds \n\t ids=" + ids);
        return ResponseEntity.ok().body(xyzService.getByIds(ids));
    }

    @PostMapping(value = "/findall")
    public ResponseEntity<Object> findItemsByExample(@RequestBody Match<Xyz> match) {
        List<Xyz> xyzs = xyzService.findAllByExample(match);
        return ResponseEntity.ok().body(xyzs);
    }

    @PostMapping(value = "/findone")
    public ResponseEntity<Object> findItemByExample(@RequestBody Match<Xyz> match) {
        Xyz xyz = xyzService.findOneByExample(match);
        return ResponseEntity.ok().body(xyz);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createXyz(@RequestBody Xyz xyz) {
        System.out.println("» XyzController - CreateXyz: " + xyz.toString());
        long newId = xyzService.create(xyz);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{xyzString}")
//                .buildAndExpand(newId).toUri();
//
//        return ResponseEntity.created(location).build();
        return new ResponseEntity<>(String.format("Xyz %d created", newId), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateXyz(@PathVariable("id") long id,
                                            @RequestBody Xyz xyz) {
        xyzService.update(id, xyz);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteXyz(@PathVariable("id") long id) {
        xyzService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

/*

 */