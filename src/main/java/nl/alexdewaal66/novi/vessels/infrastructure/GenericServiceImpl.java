package nl.alexdewaal66.novi.vessels.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nl.alexdewaal66.novi.vessels.exceptions.BadRequestException;
import nl.alexdewaal66.novi.vessels.exceptions.RecordNotFoundException;
import nl.alexdewaal66.novi.vessels.infrastructure.deletion.Deletion;
import nl.alexdewaal66.novi.vessels.infrastructure.deletion.DeletionService;
import nl.alexdewaal66.novi.vessels.payload.Mutations;
import nl.alexdewaal66.novi.vessels.utils.AuthorizationHelper;
import nl.alexdewaal66.novi.vessels.utils.Match;
import nl.alexdewaal66.novi.vessels.utils.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public class GenericServiceImpl<T extends BaseEntity<T>>
        implements GenericService<T> {

    protected final GenericRepository<T> repository;

    private final String entityName;

    @Autowired
    private DeletionService deletionService;

    @Autowired
    private AuthorizationHelper authorizationHelper;

    public GenericServiceImpl(GenericRepository<T> repository, String entityName) {
        this.repository = repository;
        this.entityName = entityName.toLowerCase();
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
    public List<T> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Collection<T> getAll() {
        return repository.findAll();
    }

    //---------------------------------------------------------------------------------
    @Override
    public Mutations<T> getByTimestampAfter(Timestamp timestamp) {
        Collection<T> fresh = repository.findAllByTimestampAfter(timestamp);

        Collection<Deletion> deleted = deletionService.findDeletions(this.entityName, timestamp);
        return new Mutations<>(fresh, deleted);
    }
    //---------------------------------------------------------------------------------

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
        String principalName = authorizationHelper.getPrincipalName();
        return create(item, principalName);
    }

    @Override
    public Long create(T item, String owner) {
        item.setId(null); // protects from overwriting existing instance
        item.setOwner(owner);
        T newItem = repository.save(item);
        return newItem.getId();
    }

    @Override
    public Object update(Long id, T newItem) {
        if (exists(id)) {
            T oldItem = repository.getOne(id);
            String owner = oldItem.getOwner();
            if (authorizationHelper.isEligible(owner)) {
                newItem.setId(id);
                newItem.setOwner(owner);
                newItem.setUpdater(authorizationHelper.getPrincipalName());
                repository.save(newItem);
                //todo: choose return value or skip entirely
                return new UpdateResponse(true, "");
            } else {
                throw new BadRequestException("User not eligible to update " + entityName + ": " + id);
            }
        } else {
//            System.out.printf("❌ RecordNotFoundException(\"%s\", %d)%n", newItem.getClass().getSimpleName(), id);
            System.out.printf("❌ RecordNotFoundException(\"%s\", %d)%n", entityName, id);
            throw new RecordNotFoundException(entityName, id);
        }
    }

    @Getter
    @AllArgsConstructor
    private static class UpdateResponse {
        private final boolean saved;
        private final String reason;
    }

    @Override
    public void delete(Long id) {
        if (exists(id)) {
            T oldItem = repository.getOne(id);
            String owner = oldItem.getOwner();
            if (authorizationHelper.isEligible(owner)) {
                deletionService.create(entityName, id);
                repository.deleteById(id);
            } else {
                throw new BadRequestException("User not eligible to delete " + entityName + ": " + id);
            }
        } else {
            throw new RecordNotFoundException(entityName, id);
        }
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

}


//    @Override
//    public SummaryProjection<T> getSummaryById(Long id) {
//        return null;
//    }

//    @Override
//    public Collection<SummaryProjection<T>> getSummariesByIds(List<Long> ids) {
//        return (Collection<SummaryProjection<T>>) repository.findSummariesByIdIn(ids);
//    }

//    @Override
//    public Collection<SummaryProjection<T>> getAllSummaries() {
//        return (Collection<SummaryProjection<T>>) repository.findAllSummariesBy();
////        return repository.findAllSummariesBy();
//    }
