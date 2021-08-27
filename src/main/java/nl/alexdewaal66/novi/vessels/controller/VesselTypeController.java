package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.service.VesselTypeService;

@RestController
@RequestMapping(value = "/vesseltypes")
@CrossOrigin(origins = "*")
public class VesselTypeController {

    @Autowired
    private VesselTypeService vesselTypeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getVesselTypes() {
        return ResponseEntity.ok().body(vesselTypeService.getVesselTypes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getVesselType(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(vesselTypeService.getVesselTypeById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createVesselType(@RequestBody VesselType vesselType) {
        System.out.println("» VesselTypeController - CreateVesselType: " + vesselType.toString());
        long newId = vesselTypeService.createVesselType(vesselType);
        return new ResponseEntity<>(String.format("VesselType %d created", newId), HttpStatus.CREATED);
    }

    // PUT=UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateVesselType(@PathVariable("id") long id,
                                                   @RequestBody VesselType vesselType) {
        vesselTypeService.updateVesselType(id, vesselType);
        return ResponseEntity.noContent().build();
    }

    // PATCH=PARTIAL-UPDATE

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteVesselType(@PathVariable("id") long id) {
        vesselTypeService.deleteVesselType(id);
        return ResponseEntity.noContent().build();
    }

}
