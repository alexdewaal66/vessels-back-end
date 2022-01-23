package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
//import nl.alexdewaal66.novi.vessels.generics.Summary;
import nl.alexdewaal66.novi.vessels.utils.Console;
import nl.alexdewaal66.novi.vessels.utils.Match;
import nl.alexdewaal66.novi.vessels.utils.Matcher;
import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.List;

//@Service
public class GenericServiceImpl<T extends GenericEntity<T>>
        implements GenericService<T> {

    protected final GenericRepository<T> repository;
//    public final Class<Summary<T>> typeParameterClass;

    // GenericRepository<> is not to be a bean by design, error reported by IntelliJ is erroneous
    @SuppressWarnings(value = "SpringJavaInjectionPointsAutowiringInspection")
    public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public Collection<IdProjection> getAllIds() {
        return repository.findBy();
    }

//    @Override
//    public List<Summary<T>> getSummariesByIds(List<Long> ids) {
//        return repository.findById(ids, typeParameterClass);
//    }

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
        System.out.println("GenericServiceImpl » findAllByExample()\n\tmatch = " + match);
        Example<T> example = Example.of(probe, Matcher.build(mode, probe.getTextProperties()));
        return repository.findAll(example);
    }

    @Override
    public Long create(T item) {
//        System.out.println("» GenericServiceImpl » create()"
//                + "\n\t item=" + item.toString());
        item.setId(null); // protects from overwriting existing instance
//        System.out.println("» GenericServiceImpl » create()"
//                + "\n\t item=" + item.toString());
        T newItem = repository.save(item);
//        System.out.println("» GenericServiceImpl » create()"
//                + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
    }

    @Override
    public void update(Long id, T newItem) {
        if (exists(id)) {
            String className = newItem.getClass().getSimpleName();
            String path = "GenericServiceImpl<" + className + "> » update() ";
//            Console.logv(path + "*before* setId()" , "newItem=" + newItem);
            newItem.setId(id);
            Console.logv(path + "*after* setId()" , "newItem=" + newItem);
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











