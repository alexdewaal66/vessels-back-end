package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.alexdewaal66.novi.vessels.model.UNLocode;
import nl.alexdewaal66.novi.vessels.service.UNLocodeService;

import java.util.List;

@RestController
@RequestMapping(value = "/un_locode")
@CrossOrigin(origins = "*")
public class UNLocodeController extends GenericController<UNLocode> {

    @Autowired
    private UNLocodeService unLocodeService;
    
    public UNLocodeController(GenericServiceImpl<UNLocode> service) {
        super(service);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Object> getUNLocodeByCodes(
            @RequestParam(name = "alpha2code") String alpha2Code,
            @RequestParam(name = "locationcode") String locationCode) {
        return ResponseEntity.ok().body(unLocodeService
                .getUNLocodeByCodes(alpha2Code, locationCode)
        );
    }
}
