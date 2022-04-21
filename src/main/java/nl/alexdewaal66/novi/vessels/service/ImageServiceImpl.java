package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.DBFile;
import nl.alexdewaal66.novi.vessels.model.Image;
import nl.alexdewaal66.novi.vessels.model.ImageSummary;
import nl.alexdewaal66.novi.vessels.repository.DBFileRepository;
import nl.alexdewaal66.novi.vessels.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nl.alexdewaal66.novi.vessels.utils.ImageHelper.resizeImage;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;
import static nl.alexdewaal66.novi.vessels.utils.Console.pair;

@Service
public class ImageServiceImpl
        extends GenericServiceImpl<Image>
        implements ImageService {

    public ImageServiceImpl(ImageRepository repository) {
        super(repository);
    }

    @Autowired
    private DBFileRepository fileRepository;

    @Autowired
    private DBFileService fileService;


    private DBFile resizeImageFile(DBFile fullSize) {
        DBFile thumbnail = new DBFile();
        thumbnail.setContent(resizeImage(fullSize.getContent(), fullSize.getFileType()));
        thumbnail.setFileType(fullSize.getFileType());
        // todo: replace crude name/extension separator by something robust
        String[] parts = fullSize.getFileName().split("\\.");
        thumbnail.setFileName(parts[0] + "_small." + parts[1]);
        return thumbnail;
    }

    @Override
    public Long create(Image image) {
//        logv("» GenericServiceImpl » create() #1", "image" + image);
        image.setId(null); // protects from overwriting existing instance
//        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
//        logv("» GenericServiceImpl » create() #2", "fullSizeDBFile" + fullSizeDBFile);
        image.setFullSize(fullSizeDBFile);
        // shrink image and create shrunkenFile
        DBFile shrunkenFile = resizeImageFile(fullSizeDBFile);
//        logv("» GenericServiceImpl » create() #3", "shrunkenFile" + shrunkenFile);
//        Long thumbnailId = fileService.create(shrunkenFile) ;
//        DBFile thumbnailDBFile = fileService.getById(thumbnailId);
        DBFile thumbnailDBFile = fileRepository.save(shrunkenFile) ;
//        logv("» GenericServiceImpl » create() #4", "thumbnailDBFile" + thumbnailDBFile);
        image.setThumbnail(thumbnailDBFile);
//        logv("» GenericServiceImpl » create() #5", pair("image", image));
        Image newItem = repository.save(image);
//        System.out.println("» GenericServiceImpl » create()" + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
    }

    public ImageSummary create2(Image image) {
//        logv("» GenericServiceImpl » create() #1", "image" + image);
        image.setId(null); // protects from overwriting existing instance
//        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
//        logv("» GenericServiceImpl » create() #2", "fullSizeDBFile" + fullSizeDBFile);
        image.setFullSize(fullSizeDBFile);
        // shrink image and create shrunkenFile
        DBFile shrunkenFile = resizeImageFile(fullSizeDBFile);
//        logv("» GenericServiceImpl » create() #3", "shrunkenFile" + shrunkenFile);
//        Long thumbnailId = fileService.create(shrunkenFile) ;
//        DBFile thumbnailDBFile = fileService.getById(thumbnailId);
        DBFile thumbnailDBFile = fileRepository.save(shrunkenFile) ;
//        logv("» GenericServiceImpl » create() #4", "thumbnailDBFile" + thumbnailDBFile);
        image.setThumbnail(thumbnailDBFile);
//        logv("» GenericServiceImpl » create() #5", pair("image", image));
        Image newItem = repository.save(image);
//        System.out.println("» GenericServiceImpl » create()" + "\n\t newItem=" + newItem.toString());
        return (ImageSummary) repository.findSummaryById(newItem.getId());
    }


}
