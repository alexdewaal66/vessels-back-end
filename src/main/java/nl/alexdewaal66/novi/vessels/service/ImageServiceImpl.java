package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.DBFile;
import nl.alexdewaal66.novi.vessels.model.Image;
import nl.alexdewaal66.novi.vessels.model.ImageSummary;
import nl.alexdewaal66.novi.vessels.repository.DBFileRepository;
import nl.alexdewaal66.novi.vessels.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nl.alexdewaal66.novi.vessels.utils.ImageHelper.resizeImage;

import static nl.alexdewaal66.novi.vessels.utils.Console.logv;

@Service
public class ImageServiceImpl
        extends GenericServiceImpl<Image>
        implements ImageService {

    public ImageServiceImpl(ImageRepository repository) {
        super(repository, "Image");
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
        image.setId(null); // protects from overwriting existing instance
        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
        image.setFullSize(fullSizeDBFile);
        // shrink image and create shrunkenFile
        DBFile shrunkenFile = resizeImageFile(fullSizeDBFile);
        DBFile thumbnailDBFile = fileRepository.save(shrunkenFile) ;
        image.setThumbnail(thumbnailDBFile);
        Image newItem = repository.save(image);
        return newItem.getId();
    }

    public ImageSummary create2(Image image) {
        image.setId(null); // protects from overwriting existing instance
        DBFile fullSizeDBFile = fileService.getById(image.getFullSizeId());
        image.setFullSize(fullSizeDBFile);
        // shrink image and create shrunkenFile
        DBFile shrunkenFile = resizeImageFile(fullSizeDBFile);
        DBFile thumbnailDBFile = fileRepository.save(shrunkenFile) ;
        image.setThumbnail(thumbnailDBFile);
        Image newItem = repository.save(image);
        return (ImageSummary) repository.findSummaryById(newItem.getId());
    }


}
