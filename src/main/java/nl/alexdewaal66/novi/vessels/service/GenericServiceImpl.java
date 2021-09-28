package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.model.GenericEntity;
import nl.alexdewaal66.novi.vessels.model.ProjectId;
import nl.alexdewaal66.novi.vessels.repository.GenericRepository;
import nl.alexdewaal66.novi.vessels.utils.Match;
import nl.alexdewaal66.novi.vessels.utils.Matcher;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

//@Service
//public class GenericServiceImpl<T extends GenericEntity, R extends GenericRepository<T>>
//        implements GenericService<T, R> {
//
//    private R repository;

//@Service
//public class GenericServiceImpl<T extends GenericEntity, R extends GenericRepository<T>>
//        implements GenericService<T, R> {
@Service
public class GenericServiceImpl<T extends GenericEntity>
        implements GenericService<T> {

    private final GenericRepository<T> repository;

    // GenericRepository<> is not to be a bean by design
    @SuppressWarnings(value="SpringJavaInjectionPointsAutowiringInspection")
    public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public Collection<ProjectId> getAllIds() {
        return repository.findAllBy();
    }

    @Override
    public T getById(Long id) {
        return repository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @Override
    public List<T> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Collection<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T findOneByExample(Match<T> match) {
        T probe = match.getProbe();
        String mode = match.getMode();
        Example<T> example = Example.of(probe, Matcher.build(mode, T.textProperties));
        return repository.findOne(example)
                .orElseThrow(() -> new BadRequestException("no result found"));
    }

    @Override
    public List<T> findAllByExample(Match<T> match) {
        T probe = match.getProbe();
        String mode = match.getMode();
        Example<T> example = Example.of(probe, Matcher.build(mode, T.textProperties));
        return repository.findAll(example);
    }

    @Override
    public Long create(T item) {
        item.setId(0L); // protects from overwriting existing instance
        T newItem = repository.save(item);
        return newItem.getId();
    }

    @Override
    public void update(Long id, T newItem) {
        if (exists(id)) {
            newItem.setId(id);
            repository.save(newItem);
        } else {
            System.out.printf("❌ RecordNotFoundException(\"%s\", %d)%n", T.entityName, id);
            throw new RecordNotFoundException(T.entityName, id);
        }
    }

    @Override
    public void delete(Long id) {
        if (exists(id)) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}











