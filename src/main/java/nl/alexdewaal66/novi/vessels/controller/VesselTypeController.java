package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.service.VesselTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    todo: POST, PUT, DELETE

}
