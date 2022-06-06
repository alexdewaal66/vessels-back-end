package nl.alexdewaal66.novi.vessels.infrastructure;

import nl.alexdewaal66.novi.vessels.infrastructure.Deletion;

import java.sql.Timestamp;
import java.util.Collection;

public interface DeletionService {
    Collection<Deletion> findDeletions(String entityName, Timestamp timestamp);

    void create(String entityName, Long itemId);
}
