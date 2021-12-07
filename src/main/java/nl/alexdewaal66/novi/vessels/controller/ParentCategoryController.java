package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.model.ParentCategory;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parentcategories")
@CrossOrigin(origins = "*")
public class ParentCategoryController extends GenericController<ParentCategory> {
    public ParentCategoryController(GenericServiceImpl<ParentCategory> service) {
        super(service);
    }
}
