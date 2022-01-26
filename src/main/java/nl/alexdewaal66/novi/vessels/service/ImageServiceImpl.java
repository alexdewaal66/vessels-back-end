package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.DBFile;
import nl.alexdewaal66.novi.vessels.model.Image;
import nl.alexdewaal66.novi.vessels.repository.DBFileRepository;
import nl.alexdewaal66.novi.vessels.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@Service
public class ImageServiceImpl
        extends GenericServiceImpl<Image>
        implements ImageService {

    public ImageServiceImpl(ImageRepository repository) {
        super(repository);
    }

    @Autowired
    private DBFileService fileService;


        @Override
    public Long create(Image image) {
        logv("» GenericServiceImpl » create()", "image" + image);
//        DBFile fullSizeFile = dbFileRepository.findById(id).orElse(null);
        image.setId(null); // protects from overwriting existing instance
        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
        image.setFullSize(fullSizeDBFile);
        // shrink image and create shrunkenFile
        // -->   thumbnailId = fileService.create(shrunkenFile) ;
        // -->   DBFile thumbnailDBFile = fileService.getById(thumbnailId);
        // -->   image.setThumbnail(thumbnailDBFile);
//        System.out.println("» GenericServiceImpl » create()" + "\n\t item=" + item.toString());
        Image newItem = repository.save(image);
//        System.out.println("» GenericServiceImpl » create()" + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
    }


}
