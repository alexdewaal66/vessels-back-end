package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.service.VesselTypeService;

import java.util.List;

@RestController
@RequestMapping(value = "/vesseltypes")
@CrossOrigin(origins = "*")
public class VesselTypeController extends GenericController<VesselType> {

//    @Autowired
//    private VesselTypeService vesselTypeService;

    public VesselTypeController(GenericServiceImpl<VesselType> service) {
        super(service);
    }

}
