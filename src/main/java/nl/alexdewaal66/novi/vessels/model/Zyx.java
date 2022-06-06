package nl.alexdewaal66.novi.vessels.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity @ToString @NoArgsConstructor
public class Zyx extends BaseEntity<Zyx> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("name", "description");
    }


    @Size(max = 100)
    @Column(name = "item_name")
    private String name;

    @Size(max = 1000)
    private String description;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}