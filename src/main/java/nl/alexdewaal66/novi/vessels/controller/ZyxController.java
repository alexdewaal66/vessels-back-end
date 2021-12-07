package nl.alexdewaal66.novi.vessels.controller;
import nl.alexdewaal66.novi.vessels.generics.GenericController;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.service.ZyxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zyxs")
@CrossOrigin(origins = "*")
public class ZyxController extends GenericController<Zyx> {

    @Autowired
    private ZyxService zyxService;

    public ZyxController(GenericServiceImpl<Zyx> service) {
        super(service);
    }

}
