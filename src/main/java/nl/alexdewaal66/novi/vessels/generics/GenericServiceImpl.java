package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.utils.Console;
import nl.alexdewaal66.novi.vessels.utils.Match;
import nl.alexdewaal66.novi.vessels.utils.Matcher;
import org.springframework.data.domain.Example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static nl.alexdewaal66.novi.vessels.utils.Console.*;

public class GenericServiceImpl<T extends GenericEntity<T>>
        implements GenericService<T> {

    protected final GenericRepository<T> repository;

    // GenericRepository2<> is by design not to be a bean, error reported by IntelliJ is erroneous
    public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public Collection<IdProjection> getAllIds() {
        return repository.findBy();
    }

    @Override
    public T getById(Long id) {
        return repository.findById(id).orElseThrow(RecordNotFoundException::new);
    }
    @Override
    public SummaryProjection<T> getSummaryById(Long id) {
        return null;
    }

    @Override
    public List<T> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
    @Override
    public Collection<SummaryProjection<T>> getSummariesByIds(List<Long> ids) {
        return (Collection<SummaryProjection<T>>) repository.findSummariesByIdIn(ids);
    }

    @Override
    public Collection<T> getAll() {
        return repository.findAll();
    }
    @Override
    public Collection<SummaryProjection<T>> getAllSummaries() {
        return (Collection<SummaryProjection<T>>) repository.findAllSummariesBy();
    }

    @Override
    public Collection<T> getByTimestampAfter(Timestamp timestamp) {
        return repository.findAllByTimestampAfter(timestamp);
    }


    @Override
    public T findOneByExample(Match<T> match) {
        T probe = match.getProbe();
        String mode = match.getMode();
        System.out.println("GenericServiceImpl2 » findOneByExample()" +
                "\n\tmatch = " + match +
                "\n\tgetEntityName() = " + probe.getClass().getSimpleName() +
                "\n\tgetTextProperties() = " + probe.getTextProperties());
        Example<T> example = Example.of(probe, Matcher.build(mode, probe.getTextProperties()));
        return repository.findOne(example)
                .orElseThrow(() -> new BadRequestException("no result found"));
    }

    @Override
    public List<T> findAllByExample(Match<T> match) {
        T probe = match.getProbe();
        String mode = match.getMode();
        System.out.println("GenericServiceImpl2 » findAllByExample()\n\tmatch = " + match);
        Example<T> example = Example.of(probe, Matcher.build(mode, probe.getTextProperties()));
        return repository.findAll(example);
    }

    @Override
    public Long create(T item) {
        String className = item.getClass().getSimpleName();
        if (className.equals("Image")) {
            Console.logv("» GenericServiceImpl » create()", "item=" + item);
        }
        item.setId(null); // protects from overwriting existing instance
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t item=" + item.toString());
        T newItem = repository.save(item);
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
    }

    @Override
    public IdContainer create1(T item) {
        String className = item.getClass().getSimpleName();
        if (className.equals("Image")) {
            Console.logv("» GenericServiceImpl » create()", "item=" + item);
        }
        item.setId(null); // protects from overwriting existing instance
        logv(classCheck(item, "Hull"),
                "» GenericServiceImpl » create1()", pair("item", item));
        T newItem = repository.save(item);
        logv(classCheck(item, "Hull"),
                "» GenericServiceImpl » create1()", pair("newItem", newItem));
        IdContainer idItem = new IdContainer();
        idItem.setId(newItem.getId());
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t item=" + item.toString());
        return idItem;
    }

    @Override
//    public SummaryProjection<T> create2(T item) {
    public Object create2(T item) {
        if (classCheck(item, "Xyz")) {
            Console.logv("» GenericServiceImpl » create2()", "item=" + item);
        }
        item.setId(null); // protects from overwriting existing instance
        T newItem = repository.save(item);
        if (classCheck(item, "Xyz")) {
            Console.logv("» GenericServiceImpl » create2()", "newItem=" + newItem);
        }
//        SummaryProjection<T> summary = repository.findSummaryById(newItem.getId());
        Collection<Long> ids = Arrays.asList(newItem.getId());
        Collection<SummaryProjection<T>> summaryList = (Collection<SummaryProjection<T>>) repository.findSummariesByIdIn(ids);
//        Object summary = repository.findSummaryById(newItem.getId());
        Object summary = summaryList.iterator().next();
        return summary;
    }


    @Override
    public void update(Long id, T newItem) {
        if (exists(id)) {
            String className = newItem.getClass().getSimpleName();
            String path = "GenericServiceImpl2<" + className + "> » update() ";
//            Console.logv(path + "*before* setId()" , "newItem=" + newItem);
            newItem.setId(id);
            Console.logv(path + "*after* setId()", "newItem=" + newItem);
            repository.save(newItem);
        } else {
            System.out.printf("❌ RecordNotFoundException(\"%s\", %d)%n", newItem.getClass().getSimpleName(), id);
            throw new RecordNotFoundException(newItem.getClass().getSimpleName(), id);
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

