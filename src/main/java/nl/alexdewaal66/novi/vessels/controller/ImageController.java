package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Image;
import nl.alexdewaal66.novi.vessels.service.ImageServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/images")
@CrossOrigin(origins = "*")
public class ImageController extends GenericController<Image> {

    public ImageController(ImageServiceImpl service) { super(service); }

}
