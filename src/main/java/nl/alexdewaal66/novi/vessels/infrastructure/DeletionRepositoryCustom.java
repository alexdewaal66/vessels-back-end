package nl.alexdewaal66.novi.vessels.infrastructure;

import nl.alexdewaal66.novi.vessels.infrastructure.Deletion;

import java.sql.Timestamp;
import java.util.Collection;

public interface DeletionRepositoryCustom {
    Collection<Deletion> findDeletions(String entityName, Timestamp timestamp);
}
