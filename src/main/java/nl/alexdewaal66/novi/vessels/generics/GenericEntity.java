package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface GenericEntity<T> {

    List<String> getTextProperties();

//    List<Property> getProperties();

    Long getId();
    void setId(Long id);

    Timestamp getTimestamp();

    String getOwner();
    void setOwner(String owner);

    String getUpdater();
    void setUpdater(String updater);
}
