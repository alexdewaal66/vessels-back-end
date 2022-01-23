package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.Category;
import nl.alexdewaal66.novi.vessels.repository.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl
        extends GenericServiceImpl<Category>
        implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

}
