package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.utils.Match;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public interface GenericService<T extends GenericEntity<T>> {

    Collection<IdProjection> getAllIds();

    T getById(Long id);
    SummaryProjection<T> getSummaryById(Long id);

    List<T> getByIds(List<Long> ids);
    Collection<SummaryProjection<T>> getSummariesByIds(List<Long> ids);

    Collection<T> getAll();
    Collection<SummaryProjection<T>> getAllSummaries();

     Collection<T> getByTimestampAfter(Timestamp timestamp);

    T findOneByExample(Match<T> match);

    //    todo: List =>> Collection
    List<T> findAllByExample(Match<T> match);

    Long create(T item);
    IdContainer create1(T item);
    //    SummaryProjection<T> create2(T item);
    Object create2(T item);

    Object update(Long id, T newItem);

    void delete(Long id);

    boolean exists(Long id);
}

