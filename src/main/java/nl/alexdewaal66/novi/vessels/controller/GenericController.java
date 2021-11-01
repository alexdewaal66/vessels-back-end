package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.model.GenericEntity;
import nl.alexdewaal66.novi.vessels.model.Xyz;
import nl.alexdewaal66.novi.vessels.service.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T extends GenericEntity> {

    private final GenericServiceImpl<T> service;

//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public GenericController(GenericServiceImpl<T> service) {
        this.service = service;
    }

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getIds() {
        return ResponseEntity.ok().body(service.getAllIds());
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> get() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getByIds(@RequestBody List<Long> ids) {
        System.out.println("GenericController » getByIds \n\t ids=" + ids);
        return ResponseEntity.ok().body(service.getByIds(ids));
    }

    @PostMapping(value = "/findall")
    public ResponseEntity<Object> findItemsByExample(@RequestBody Match<T> match) {
        List<T> items = service.findAllByExample(match);
        return ResponseEntity.ok().body(items);
    }

    @PostMapping(value = "/findone")
    public ResponseEntity<Object> findItemByExample(@RequestBody Match<T> match) {
        T item = service.findOneByExample(match);
        return ResponseEntity.ok().body(item);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> create(@RequestBody T item) {
        System.out.println("» GenericController » create() \n\titem=" + item.toString());
        long newId = service.create(item);
        return new ResponseEntity<>(String.format("%s %d created", item.getEntityName(), newId), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id,
                                            @RequestBody T item) {
        service.update(id, item);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteXyz(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}