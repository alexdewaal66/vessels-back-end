package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class DeletionServiceImpl implements DeletionService {

    final
    DeletionRepository repository;
    public DeletionServiceImpl(DeletionRepository repository) {
        this.repository = repository;
    }
    @Override
    public Collection<Deletion> findDeletions(String entityName, Timestamp timestamp) {
        return repository.findDeletions(entityName, timestamp);
    }

    @Override
    public void create(String entityName, Long itemId) {
        Deletion deletion = new Deletion();
        deletion.setEntityName(entityName);
        deletion.setItemId(itemId);
        repository.save(deletion);
    }
}
