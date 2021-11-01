//package nl.alexdewaal66.novi.vessels.repository;
//
//import nl.alexdewaal66.novi.vessels.model.VesselType;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//public class VesselTypeRepositoryImpl
//        implements GenericRepositoryCustom<VesselType> {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override @Transactional
//    public VesselType save(Long id) {
//        return entityManager.getReference(VesselType.class, id);
//    }
//}
