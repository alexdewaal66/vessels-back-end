package nl.alexdewaal66.novi.vessels.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T>> extends JpaRepository<T, Long> {
    Collection<IdProjection> findBy();

    Collection<? extends SummaryProjection<T>> findAllSummariesBy();

    Collection<? extends SummaryProjection<T>> findSummariesByIdIn(Collection<Long> ids);

    SummaryProjection<T> findSummaryById(Long id);
}
