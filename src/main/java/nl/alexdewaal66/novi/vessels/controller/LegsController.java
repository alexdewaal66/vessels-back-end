package nl.alexdewaal66.novi.vessels.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nl.alexdewaal66.novi.vessels.utils.Triangle;


@RestController
@RequestMapping(value = "/legs")
public class LegsController {

    Triangle triangle = new Triangle();

    @GetMapping(value = "")
    public ResponseEntity<Object> getLegs(
            @RequestParam(value = "adjacent") double adjacent,
            @RequestParam(value = "opposite") double opposite){
        triangle.setHypotenuse(Math.sqrt(adjacent * adjacent + opposite * opposite));
        return ResponseEntity.status(HttpStatus.OK).body(triangle);
    }

}
