package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.utils.Property;

import javax.persistence.Id;
import java.util.List;

public interface GenericEntity {

    //    List<Property> getProperties();
    String entityName = null;
    List<String> textProperties = null;

    Long getId();
    void setId(Long id);

}
