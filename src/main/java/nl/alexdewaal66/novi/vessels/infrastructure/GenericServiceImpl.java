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

    // GenericRepository2<> is by design not to be a bean, error reported by IntelliJ is erroneous
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

//    @Override
//    public SummaryProjection<T> getSummaryById(Long id) {
//        return null;
//    }

    @Override
    public List<T> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

//    @Override
//    public Collection<SummaryProjection<T>> getSummariesByIds(List<Long> ids) {
//        return (Collection<SummaryProjection<T>>) repository.findSummariesByIdIn(ids);
//    }

    @Override
    public Collection<T> getAll() {
        return repository.findAll();
    }

//    @Override
//    public Collection<SummaryProjection<T>> getAllSummaries() {
//        return (Collection<SummaryProjection<T>>) repository.findAllSummariesBy();
////        return repository.findAllSummariesBy();
//    }

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
//        String className = item.getClass().getSimpleName();
//        Console.logv(className.equals("Image"), "» GenericServiceImpl » create()", "item=" + item);
        item.setId(null); // protects from overwriting existing instance
        item.setOwner(authorizationHelper.getPrincipalName());
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t item=" + item.toString());
        T newItem = repository.save(item);
//        System.out.println("» GenericServiceImpl2 » create()"
//                + "\n\t newItem=" + newItem.toString());
        return newItem.getId();
    }

//    @Override
//    public IdContainer create1(T item) {
//        String className = item.getClass().getSimpleName();
////        Console.logv(className.equals("Image"), "» GenericServiceImpl » create()", "item=" + item);
//        item.setId(null); // protects from overwriting existing instance
////        logv(classCheck(item, "Hull"), "» GenericServiceImpl » create1()", pair("item", item));
//        T newItem = repository.save(item);
////        logv(classCheck(item, "Hull"), "» GenericServiceImpl » create1()", pair("newItem", newItem));
//        IdContainer idItem = new IdContainer();
//        idItem.setId(newItem.getId());
////        System.out.println("» GenericServiceImpl2 » create()"
////                + "\n\t item=" + item.toString());
//        return idItem;
//    }

//    @Override
////    public SummaryProjection<T> create2(T item) {
//    public Object create2(T item) {
////        Console.logv(classCheck(item, "Xyz"),"» GenericServiceImpl » create2()", "item=" + item);
//        item.setId(null); // protects from overwriting existing instance
//        T newItem = repository.save(item);
////        Console.logv(classCheck(item, "Xyz")"» GenericServiceImpl » create2()", "newItem=" + newItem);
////        SummaryProjection<T> summary = repository.findSummaryById(newItem.getId());
//        Collection<Long> ids = Arrays.asList(newItem.getId());
////        Collection<SummaryProjection<T>> summaryList = (Collection<SummaryProjection<T>>) repository.findSummariesByIdIn(ids);// used
//        Collection<SummaryProjection<T>> summaryList = repository.findSummariesByIdIn(ids);
////        Object summary = repository.findSummaryById(newItem.getId());
//        return summaryList.iterator().next();
//    }


    @Override
    public Object update(Long id, T newItem) {
        if (exists(id)) {
//            String className = newItem.getClass().getSimpleName();
//            String path = "GenericServiceImpl<" + className + "> » update() ";
//            Console.logv(path + "*before* setId()" , "newItem=" + newItem);
            newItem.setId(id);
//            Console.logv(path + "*after* setId()", "newItem=" + newItem);
            T oldItem = repository.getOne(id);
            String owner = oldItem.getOwner();
            if (authorizationHelper.isEligible(owner)) {
                newItem.setOwner(owner);
                newItem.setUpdater(authorizationHelper.getPrincipalName());
                repository.save(newItem);
                //todo: choose return value or skip entirely
//                return new Object() {final boolean saved = true;};
//                return "saved";
                return new UpdateResponse(true, "");
            } else {
                throw new BadRequestException("user not eligible to update this item");
            }
        } else {
            System.out.printf("❌ RecordNotFoundException(\"%s\", %d)%n", newItem.getClass().getSimpleName(), id);
            throw new RecordNotFoundException(newItem.getClass().getSimpleName(), id);
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
//            String path = "GenericServiceImpl<" + className + "> » delete() ";
//            Console.logv(path, "owner=" + owner, "principal=" + principal);
            if (authorizationHelper.isEligible(owner)) {
                //todo: replace getSimpleName by getName ?
                String className = oldItem.getClass().getSimpleName();
                int dollarIndex = className.indexOf('$');
                String entityName = className.substring(0, dollarIndex).toLowerCase();
                deletionService.create(entityName, id);
                repository.deleteById(id);
            } else {
                throw new BadRequestException("user not eligible to delete this item");
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}

