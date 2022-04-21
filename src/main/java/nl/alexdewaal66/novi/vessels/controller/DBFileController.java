package nl.alexdewaal66.novi.vessels.controller;

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
public class DBFileController {

    @Autowired
    private DBFileServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile mpFile) {
//        Console.logv("\n\n🛄🛄🛄🛄🛄🛄🛄🛄🛄 \n DBFileController » create", "mpFile = " + mpFile);
        Long newId = service.create(mpFile);
        return new ResponseEntity<>(String.format("%s %d created", "file", newId), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ids")
    public ResponseEntity<Object> getIds() {
        return ResponseEntity.ok().body(service.getAllIds());
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource download(@PathVariable("id") Long id) {
        byte[] file = service.getById(id).getContent();

        return new ByteArrayResource(file);
    }
}
