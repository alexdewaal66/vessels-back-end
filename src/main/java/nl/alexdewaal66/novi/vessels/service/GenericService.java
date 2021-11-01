package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.model.GenericEntity;
import nl.alexdewaal66.novi.vessels.model.ProjectId;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import nl.alexdewaal66.novi.vessels.utils.Match;

import java.util.Collection;
import java.util.List;

//public interface GenericService<T extends GenericEntity, R extends GenericRepository<T>> {
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
