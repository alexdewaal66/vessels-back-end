package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Image;
import nl.alexdewaal66.novi.vessels.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl
        extends GenericServiceImpl<Image>
        implements ImageService {

    public ImageServiceImpl(ImageRepository repository) { super(repository); }

}
