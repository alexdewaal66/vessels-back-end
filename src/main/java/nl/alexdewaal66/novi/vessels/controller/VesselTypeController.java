package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.service.VesselTypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.VesselType;

@RestController
@RequestMapping(value = "/vesseltypes")
@CrossOrigin(origins = "*")
public class VesselTypeController extends GenericController<VesselType> {

    public VesselTypeController(VesselTypeServiceImpl service) {
        super(service);
    }

}
