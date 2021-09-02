package nl.alexdewaal66.novi.vessels.controller;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.service.ZyxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zyxs")
@CrossOrigin(origins = "*")
public class ZyxController {

    @Autowired
    private ZyxService zyxService;

    @PostMapping(value = "")
    public ResponseEntity<Object> createZyx(@RequestBody Zyx zyx) {
        System.out.println("» ZyxController - CreateZyx: " + zyx.toString());
        long newId = zyxService.createZyx(zyx);
        return new ResponseEntity<>(String.format("Zyx %d created", newId), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getZyxIds() {
        return ResponseEntity.ok().body(zyxService.getAllIds());
    }

    // GET=READ
    @GetMapping(value = "")
    public ResponseEntity<Object> getZyxs() {
        return ResponseEntity.ok().body(zyxService.getZyxs());
    }

    // GET=READ
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getZyx(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(zyxService.getZyxById(id));
    }

    // PUT=UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateZyx(@PathVariable("id") long id,
                                            @RequestBody Zyx zyx) {
        zyxService.updateZyx(id, zyx);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteZyx(@PathVariable("id") long id) {
        zyxService.deleteZyx(id);
        return ResponseEntity.noContent().build();
    }



}
/*

 */