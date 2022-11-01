package nl.alexdewaal66.novi.vessels.controller;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericController;
import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.DBFile;
import nl.alexdewaal66.novi.vessels.service.DBFileServiceImpl;
import nl.alexdewaal66.novi.vessels.utils.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/files")
@CrossOrigin(origins = "*")
public class DBFileController extends GenericController<DBFile> {

    private final DBFileServiceImpl dbFileService;
    public DBFileController(GenericServiceImpl<DBFile> service, DBFileServiceImpl dbFileService) {
        super(service);
        this.dbFileService = dbFileService;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile mpFile) {
        Long newId = dbFileService.create(mpFile);
        return new ResponseEntity<>(String.format("%s %d created", "file", newId), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getIds() {
        return ResponseEntity.ok().body(dbFileService.getAllIds());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        DBFile dbFile = dbFileService.getById(id);
//        dbFile.setContent(null);
        return ResponseEntity.ok().body(dbFile);
    }

    @GetMapping(value = "/{id}/download", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource download(@PathVariable("id") Long id) {
        Console.logv("\nDBFileController » download()", "id="+id);

        byte[] file = dbFileService.getById(id).getContent();

        System.out.println("\nfile staat klaar");
        return new ByteArrayResource(file);
    }

}
