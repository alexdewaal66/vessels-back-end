package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.utils.Console;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity @ToString
public class Category extends BaseEntity implements GenericEntity<Category> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("catName");
    }


    private String catName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parent;


    public String getCatName() { return catName; }
    public void setCatName(String catName) { this.catName = catName; }

    public Category getParent() { return parent; }
    public void setParent(Category parent) { this.parent = parent; }

}
