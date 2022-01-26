package nl.alexdewaal66.novi.vessels.generics;

import java.util.List;

public interface GenericEntity<T> {

    List<String> getTextProperties();

//    List<Property> getProperties();

    Long getId();
    void setId(Long id);
}
