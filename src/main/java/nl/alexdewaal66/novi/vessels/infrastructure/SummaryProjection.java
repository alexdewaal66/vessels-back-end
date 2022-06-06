package nl.alexdewaal66.novi.vessels.infrastructure;

import java.sql.Timestamp;

public interface SummaryProjection<T extends GenericEntity<T>> {

    Long getId();
    Timestamp getTimestamp();

}
