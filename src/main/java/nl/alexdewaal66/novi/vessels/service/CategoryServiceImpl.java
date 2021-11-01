package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.Category;
import nl.alexdewaal66.novi.vessels.model.VesselType;
import nl.alexdewaal66.novi.vessels.repository.CategoryRepository;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService{

    @Autowired
    CategoryRepository repository;

    public CategoryServiceImpl(GenericRepository<Category> repository) {
        super(repository);
    }

//    @Override
//    public Long create(Category item) {
//            System.out.println("» CategoryServiceImpl » create() *before* getId(), *before* getOne()"
//                + "\n\t item=" + item.toString());
//        Long parentId = item.getParent().getId();
//            System.out.println("» CategoryServiceImpl » create() *after* getId(), *before* getOne()"
//                + "\n\t parentId = " + parentId);
////        Category parent = repository.getOne(parentId);
//        Category p1 = repository.findById(1L).orElse(null);
//        Category parent = repository.findById(parentId).orElse(p1);
//            System.out.println("» CategoryServiceImpl » create() *after* getId(), *after* getOne()"
//                + "\n\t parent = " + parent);
//        item.setParent(parent);
//            System.out.println("» CategoryServiceImpl » create() *after* setParent()"
//                + "\n\t item=" + item.toString());
//        return super.create(item);
//    }

}
