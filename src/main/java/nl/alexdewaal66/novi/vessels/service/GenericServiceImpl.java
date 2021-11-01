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

import nl.alexdewaal66.novi.vessels.model.*;
import org.springframework.transaction.annotation.Transactional;

//@Service
public class GenericServiceImpl<T extends GenericEntity<T>>
        implements GenericService<T> {

    private final GenericRepository<T> repository;

    // GenericRepository<> is not to be a bean by design, error in IntelliJ is erroneous
    @SuppressWarnings(value = "SpringJavaInjectionPointsAutowiringInspection")
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
        System.out.println("GenericServiceImpl » findOneByExample()" +
                "\n\tmatch = " + match +
                "\n\tgetEntityName() = " + probe.getEntityName() +
                "\n\tgetTextProperties() = " + probe.getTextProperties());
        Example<T> example = Example.of(probe, Matcher.build(mode, probe.getTextProperties()));
        return repository.findOne(example)
                .orElseThrow(() -> new BadRequestException("no result found"));
    }

    @Override
    public List<T> findAllByExample(Match<T> match) {
        T probe = match.getProbe();
        String mode = match.getMode();
        System.out.println("GenericServiceImpl » findAllByExample()\n\tmatch = " + match);
        Example<T> example = Example.of(probe, Matcher.build(mode, probe.getTextProperties()));
        return repository.findAll(example);
    }

    @Override
    public Long create(T item) {
        System.out.println("» GenericServiceImpl » create()"
                + "\n\t item=" + item.toString());
        item.setId(null); // protects from overwriting existing instance
        System.out.println("» GenericServiceImpl » create()"
                + "\n\t item=" + item.toString());
//        T copy = item.shallowCopy();
//        System.out.println("» GenericServiceImpl » create()"
//                + "\n\t copy=" + copy.toString());
//        T newItem = repository.save(copy);
        T newItem = repository.save(item);
        System.out.println("» GenericServiceImpl » create()"
                + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
    }

    @Override
    public void update(Long id, T newItem) {
        if (exists(id)) {
            System.out.println("» GenericServiceImpl » update() *before* setId()"
                    + "\n\t newItem=" + newItem.toString());
            newItem.setId(id);
            System.out.println("» GenericServiceImpl » update() *after* setId()"
                    + "\n\t newItem=" + newItem.toString());
            repository.save(newItem);
        } else {
            System.out.printf("❌ RecordNotFoundException(\"%s\", %d)%n", newItem.getEntityName(), id);
            throw new RecordNotFoundException(newItem.getEntityName(), id);
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











