package nl.alexdewaal66.novi.vessels.infrastructure.deletion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collection;

@RestController
@RequestMapping(value = "/deletions")
@CrossOrigin(origins = "*")
public class DeletionController {

    @Autowired
    private DeletionService deletionService;

    @GetMapping
    public ResponseEntity<Object> deletions(
            @RequestParam(name="type") String entityName,
            @RequestParam(name= "time") String timeString
    ) {
        long millis = Long.parseLong(timeString);
        Timestamp timestamp = new Timestamp(millis);
        Collection<Deletion> result = deletionService.findDeletions(entityName, timestamp);
        return ResponseEntity.ok().body(result);
    }
}
