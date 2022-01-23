package nl.alexdewaal66.novi.vessels.generics2;

import nl.alexdewaal66.novi.vessels.generics.IdProjection;
import nl.alexdewaal66.novi.vessels.generics2.GenericEntity2;
import nl.alexdewaal66.novi.vessels.utils.Match;

import java.util.Collection;
import java.util.List;

public interface GenericService2<T extends GenericEntity2<T>> {

    Collection<IdProjection> getAllIds();

    T getById(Long id);
    List<T> getByIds(List<Long> ids);

    Collection<InterfaceSummaryProjection<T>> getSummariesByIds(List<Long> ids);

    Collection<InterfaceSummaryProjection<T>> getAllSummaries();

    Collection<T> getAll();

    T findOneByExample(Match<T> match);

    //    todo: List =>> Collection
    List<T> findAllByExample(Match<T> match);

    Long create(T item);

    void update(Long id, T newItem);

    void delete(Long id);

    boolean exists(Long id);
}

