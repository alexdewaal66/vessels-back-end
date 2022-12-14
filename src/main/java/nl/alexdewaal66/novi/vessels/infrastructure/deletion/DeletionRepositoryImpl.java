package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.Collection;

@Repository
public class DeletionRepositoryImpl implements DeletionRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    public Collection<Deletion> findDeletions(String entityName, Timestamp timestamp) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Deletion> criteriaQuery =
                criteriaBuilder.createQuery(Deletion.class);

        Root<Deletion> root = criteriaQuery.from(Deletion.class);
        Predicate timePredicate =
                criteriaBuilder.greaterThan(root.get("timestamp"),  timestamp);
        Predicate entityPredicate=
                criteriaBuilder.equal(root.get("entityName"), entityName);
        criteriaQuery.where(entityPredicate, timePredicate);

        TypedQuery<Deletion> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
