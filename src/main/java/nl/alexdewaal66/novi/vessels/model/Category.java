package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

@Entity @ToString
public class Category extends BaseEntity<Category> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return List.of("catName");
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
