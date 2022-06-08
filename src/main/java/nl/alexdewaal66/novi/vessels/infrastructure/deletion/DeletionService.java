package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import java.sql.Timestamp;
import java.util.Collection;

public interface DeletionService {
    Collection<Deletion> findDeletions(String entityName, Timestamp timestamp);

    void create(String entityName, Long itemId);
}
