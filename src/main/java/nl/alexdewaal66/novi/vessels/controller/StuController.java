package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.Stu;
import nl.alexdewaal66.novi.vessels.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stus")
public class StuController {

    @Autowired
    private StuService stuService;

    // POST=CREATE
    @PostMapping(value = "")
    public ResponseEntity<Object> createStu(@RequestBody Stu stu) {
//        long newId = stuService.createStu(stu);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{stuString}")
//                .buildAndExpand(newId).toUri();
//
//        return ResponseEntity.created(location).build();
        long newId = stuService.createStu(stu);
        return new ResponseEntity<>(String.format("Stu %d created", newId), HttpStatus.CREATED);
    }

    // GET=READ
    @GetMapping(value = "")
    public ResponseEntity<Object> getStus() {
        return ResponseEntity.ok().body(stuService.getStus());
    }

    // GET=READ
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getStu(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(stuService.getStuById(id));
    }

    // PUT=UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateStu(@PathVariable("id") long id,
                                            @RequestBody Stu stu) {
        stuService.updateStu(id, stu);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteStu(@PathVariable("id") long id) {
        stuService.deleteStu(id);
        return ResponseEntity.noContent().build();
    }
}
