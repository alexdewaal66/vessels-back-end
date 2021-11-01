//package nl.alexdewaal66.novi.vessels.repository;
//
//import nl.alexdewaal66.novi.vessels.model.Category;
//import nl.alexdewaal66.novi.vessels.repository.GenericRepositoryCustom;
//import nl.alexdewaal66.novi.vessels.model.VesselType;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//public class CategoryRepositoryImpl implements GenericRepositoryCustom<Category> {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override @Transactional
//    public Category save(Category category) {
//        return entityManager.getReference(Category.class, id);
//    }
//}
