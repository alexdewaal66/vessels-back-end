package nl.alexdewaal66.novi.vessels.infrastructure;

import nl.alexdewaal66.novi.vessels.utils.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class DeletionServiceImpl implements DeletionService {

    @Autowired
    DeletionRepository repository;
    @Override
    public Collection<Deletion> findDeletions(String entityName, Timestamp timestamp) {

        return repository.findDeletions(entityName, timestamp);
    }

    @Override
    public void create(String entityName, Long itemId) {
        Console.logv("DeletionServiceImpl » create()",
                "entityName=" + entityName, "itemId=" + itemId);
        Deletion deletion = new Deletion();
        deletion.setEntityName(entityName);
        deletion.setItemId(itemId);
        Console.logv("", "deletion=" + deletion);
        repository.save(deletion);
    }
}
