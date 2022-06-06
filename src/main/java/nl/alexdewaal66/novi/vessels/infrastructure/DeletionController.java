package nl.alexdewaal66.novi.vessels.infrastructure;


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
        System.out.println("\n\n DeletionController » deletions()" +
                "\n entityName=" + entityName +
                "\n time=" + timeString);
        long millis = Long.parseLong(timeString);
        Timestamp timestamp = new Timestamp(millis);
        System.out.println("\n timestamp=" + timestamp);
        Collection<Deletion> result = deletionService.findDeletions(entityName, timestamp);
        return ResponseEntity.ok().body(result);
    }
}
