package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.generics.ProjectId;
import nl.alexdewaal66.novi.vessels.utils.Match;

import java.util.Collection;
import java.util.List;

public interface GenericService<T extends GenericEntity> {

    Collection<ProjectId> getAllIds();

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
