package nl.alexdewaal66.novi.vessels.generics;

//import nl.alexdewaal66.novi.vessels.generics.Summary;
import nl.alexdewaal66.novi.vessels.utils.Match;

import java.util.Collection;
import java.util.List;

public interface GenericService<T extends GenericEntity<T>> {

    Collection<IdProjection> getAllIds();

//    List<Summary<T>> getSummariesByIds(List<Long> ids);

    T getById(Long id);

    //    todo: List =>> Collection
    List<T> getByIds(List<Long> ids);

    Collection<T> getAll();

    T findOneByExample(Match<T> match);

    //    todo: List =>> Collection
    List<T> findAllByExample(Match<T> match);

    Long create(T item);

    void update(Long id, T newItem);

    void delete(Long id);

    boolean exists(Long id);
}
