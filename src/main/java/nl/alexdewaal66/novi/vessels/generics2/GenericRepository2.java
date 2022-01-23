package nl.alexdewaal66.novi.vessels.generics2;

import nl.alexdewaal66.novi.vessels.generics.IdProjection;
import nl.alexdewaal66.novi.vessels.generics2.GenericEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

@NoRepositoryBean
public interface GenericRepository2<T extends GenericEntity2<T>> extends JpaRepository<T, Long> {
    Collection<IdProjection> findBy();
//    <X> Collection<X> findAllByIdIn(Collection<Long> ids, Class<X> type);
    <X> Collection<X> findAllBy();
}
