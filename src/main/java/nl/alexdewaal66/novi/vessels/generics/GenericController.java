package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static nl.alexdewaal66.novi.vessels.utils.Console.*;

public abstract class GenericController<T extends GenericEntity<T>> {

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
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(service.getByIds(ids));
    }

    @GetMapping(value = "/summaries")
    public ResponseEntity<Object> getAllSummaries() {
        return ResponseEntity.ok().body(service.getAllSummaries());
    }

    @PostMapping(value = "/summaries")
    public ResponseEntity<Object> getSummariesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(service.getSummariesByIds(ids));
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
        logv(classCheck(item, "Image"),
                "» GenericController2 » create()", p("item", item));
        Long newId = service.create(item);
//        System.out.println("» GenericController2 » create()"
//                + "\n\tid=" + newId);
        return new ResponseEntity<>(String.format("%s %d created", item.getClass().getSimpleName(), newId), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id,
                                         @RequestBody T item) {
        logv(classCheck(item, "Image"),
                "» GenericController2 » update()", p("id", id), p("item", item));
        service.update(id, item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteXyz(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
