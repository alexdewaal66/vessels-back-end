package nl.alexdewaal66.novi.vessels.controller;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.service.ZyxService;
import nl.alexdewaal66.novi.vessels.service.ZyxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zyxs")
@CrossOrigin(origins = "*")
public class ZyxController extends GenericController<Zyx> {

    private final ZyxService zyxService;

    public ZyxController(ZyxServiceImpl service, ZyxService zyxService) {
        super(service);
        this.zyxService = zyxService;
    }

}
