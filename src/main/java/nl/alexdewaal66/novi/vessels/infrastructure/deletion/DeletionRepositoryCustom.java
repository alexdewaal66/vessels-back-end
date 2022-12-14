package nl.alexdewaal66.novi.vessels.infrastructure.deletion;

import java.sql.Timestamp;
import java.util.Collection;

public interface DeletionRepositoryCustom {
    Collection<Deletion> findDeletions(String entityName, Timestamp timestamp);
}
