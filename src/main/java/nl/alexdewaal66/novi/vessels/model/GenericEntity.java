package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.utils.Property;
import org.aspectj.apache.bcel.generic.RET;

import javax.persistence.Id;
import java.util.List;

public interface GenericEntity {

    String getEntityName();

    List<String> getTextProperties();

//    List<Property> getProperties();

    Long getId();

    void setId(Long id);
}
