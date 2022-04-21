package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.model.Hull;
import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping(value = "/summaries/{id}")
    public ResponseEntity<Object> getSummary(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.getSummaryById(id));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/changed/{since}")
    public ResponseEntity<Object> getByTimestampAfter(@PathVariable("since") Long milliseconds) {
//        logv("\n GenericController » getByTimestampAfter()", "milliseconds=" + milliseconds);
        Instant instant = Instant.ofEpochMilli(milliseconds);
        Timestamp time = Timestamp.from(instant);
        Collection<T> result = service.getByTimestampAfter(time);
//        logv("\n GenericController » getByTimestampAfter()", "result=" + result);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(service.getByIds(ids));
    }

    @PostMapping(value = "/summaries")
    public ResponseEntity<Object> getSummariesByIds(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(service.getSummariesByIds(ids));
    }

    @GetMapping(value = "/summaries")
    public ResponseEntity<Object> getAllSummaries() {
        return ResponseEntity.ok().body(service.getAllSummaries());
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
//        logv(classCheck(item, "Image"), "» GenericController » create()", pair("item", item));
        Long newId = service.create(item);
//        System.out.println("» GenericController2 » create()"
//                + "\n\tid=" + newId);
//        sleep5seconds();
        return new ResponseEntity<>(String.format("%s %d created", item.getClass().getSimpleName(), newId), HttpStatus.CREATED);
    }

    @PostMapping(value = "/sum1")
    public ResponseEntity<Object> create1(@RequestBody T item) {
        boolean doLog = classCheck(item, Hull.class);
//        logv(doLog, "» GenericController » create1()", pair("item", item));
        IdContainer responseData = service.create1(item);
//        logv(doLog, "» GenericController » create1()", pair("responseData", responseData));
//        System.out.println("» GenericController » create()"
//                + "\n\tid=" + newId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @PostMapping(value = "/sum2")
    public ResponseEntity<Object> create2(@RequestBody T item) {
//        logv(classCheck(item, "Xyz"), "» GenericController2 » create2()", pair("item", item));
//        SummaryProjection<T> responseData = service.create2(item);
        Object responseData = service.create2(item);
//        logv(classCheck(item, "Xyz"), "» GenericController2 » create2()", pair("responseData", responseData));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id,
                                         @RequestBody T item) {
//        logv(classCheck(item, "Image"), "» GenericController2 » update()", pair("id", id), pair("item", item));
        Object responseData = service.update(id, item);
//        sleep5seconds();
        return ResponseEntity.ok().body(responseData);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteXyz(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private void sleep5seconds() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}
