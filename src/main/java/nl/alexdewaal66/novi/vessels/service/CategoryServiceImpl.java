package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Category;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl
        extends GenericServiceImpl<Category>
        implements CategoryService {

    public CategoryServiceImpl(GenericRepository<Category> repository) {
        super(repository);
    }

}
