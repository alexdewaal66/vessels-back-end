package nl.alexdewaal66.novi.vessels.infrastructure;

import nl.alexdewaal66.novi.vessels.payload.Mutations;
import nl.alexdewaal66.novi.vessels.utils.Match;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class GenericController<T extends BaseEntity<T>> {

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

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/changed/{since}")
    public ResponseEntity<Object> getByTimestampAfter(@PathVariable("since") Long milliseconds) {
        Timestamp timestamp=  new Timestamp(milliseconds);
        Mutations<T> result = service.getByTimestampAfter(timestamp);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/ids")
    public ResponseEntity<Object> getByIds(@RequestBody List<Long> ids) {
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
        Long newId = service.create(item);
//        sleep5seconds();
        return new ResponseEntity<>(String.format("%s %d created", item.getClass().getSimpleName(), newId), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id,
                                         @RequestBody T item) {
        Object responseData = service.update(id, item);
//        sleep5seconds();
        return ResponseEntity.ok().body(responseData);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    private void sleep5seconds() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}

//    @GetMapping(value = "/summaries/{id}")
//    public ResponseEntity<Object> getSummary(@PathVariable("id") Long id) {
//        return ResponseEntity.ok().body(service.getSummaryById(id));
//    }

//    @PostMapping(value = "/summaries")
//    public ResponseEntity<Object> getSummariesByIds(@RequestBody List<Long> ids) {
//        return ResponseEntity.ok().body(service.getSummariesByIds(ids));
//    }

//    @GetMapping(value = "/summaries")
//    public ResponseEntity<Object> getAllSummaries() {
//        return ResponseEntity.ok().body(service.getAllSummaries());
//    }

//    @PostMapping(value = "/sum1")
//    public ResponseEntity<Object> create1(@RequestBody T item) {
//        boolean doLog = classCheck(item, Hull.class);
////        logv(doLog, "» GenericController » create1()", pair("item", item));
//        IdContainer responseData = service.create1(item);
////        logv(doLog, "» GenericController » create1()", pair("responseData", responseData));
////        System.out.println("» GenericController » create()"
////                + "\n\tid=" + newId);
//        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
//    }
//
//    @PostMapping(value = "/sum2")
//    public ResponseEntity<Object> create2(@RequestBody T item) {
////        logv(classCheck(item, "Xyz"), "» GenericController2 » create2()", pair("item", item));
////        SummaryProjection<T> responseData = service.create2(item);
//        Object responseData = service.create2(item);
////        logv(classCheck(item, "Xyz"), "» GenericController2 » create2()", pair("responseData", responseData));
//        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
//    }

