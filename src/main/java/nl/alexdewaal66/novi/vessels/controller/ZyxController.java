package nl.alexdewaal66.novi.vessels.controller;
import nl.alexdewaal66.novi.vessels.generics2.GenericController2;
import nl.alexdewaal66.novi.vessels.model.Zyx;
import nl.alexdewaal66.novi.vessels.service.ZyxService;
import nl.alexdewaal66.novi.vessels.service.ZyxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zyxs")
@CrossOrigin(origins = "*")
public class ZyxController extends GenericController2<Zyx> {

    @Autowired
    private ZyxService zyxService;

    public ZyxController(ZyxServiceImpl service) {
        super(service);
    }

//    @GetMapping(value = "/summaries")
//    public ResponseEntity<Object> getSummaries() {
//        return ResponseEntity.ok().body(zyxService.getSummaries());
//    }

}
