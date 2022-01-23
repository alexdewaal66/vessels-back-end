package nl.alexdewaal66.novi.vessels.generics2;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.generics.IdProjection;
import nl.alexdewaal66.novi.vessels.utils.Console;
import nl.alexdewaal66.novi.vessels.utils.Match;
import nl.alexdewaal66.novi.vessels.utils.Matcher;
import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.List;

public class GenericServiceImpl2<T extends GenericEntity2<T>>
        implements GenericService2<T> {

    protected final GenericRepository2<T> repository;

    // GenericRepository2<> is not to be a bean by design, error reported by IntelliJ is erroneous
    @SuppressWarnings(value = "SpringJavaInjectionPointsAutowiringInspection")
    public GenericServiceImpl2(GenericRepository2<T> repository) {
        this.repository = repository;
    }

    @Override
    public Collection<IdProjection> getAllIds() {
        return repository.findBy();
    }

    @Override
    public List<T> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }


    @Override
    public T getById(Long id) {
        return repository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Collection<InterfaceSummaryProjection<T>> getSummariesByIds(List<Long> ids) {
        return (Collection<InterfaceSummaryProjection<T>>) repository.getAllByIdIn(ids);
    }

    @Override
    public Collection<InterfaceSummaryProjection<T>> getAllSummaries() {
        return (Collection<InterfaceSummaryProjection<T>>) repository.getAllBy();
    }


    @Override
    public Collection<T> getAll() {
        return repository.findAll();
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
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t item=" + item.toString());
        item.setId(null); // protects from overwriting existing instance
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t item=" + item.toString());
        T newItem = repository.save(item);
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
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

