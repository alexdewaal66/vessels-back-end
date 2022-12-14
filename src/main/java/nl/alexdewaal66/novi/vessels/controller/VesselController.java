package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Vessel;
import nl.alexdewaal66.novi.vessels.service.VesselServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vessels")
@CrossOrigin(origins = "*")
public class VesselController extends GenericController<Vessel> {

    public VesselController(VesselServiceImpl service) {
        super(service);
    }
}
