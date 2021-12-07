package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.generics.GenericService;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.ParentCategory;
import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ParentCategoryServiceImpl
        extends GenericServiceImpl<ParentCategory>
        implements GenericService<ParentCategory> {
    public ParentCategoryServiceImpl(GenericRepository<ParentCategory> repository) {
        super(repository);
    }
}

