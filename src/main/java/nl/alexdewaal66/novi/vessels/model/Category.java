package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.utils.Console;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity
public class Category extends BaseEntity implements GenericEntity<Category> {
    public Category() {
//        Console.logv("Category » Category()");
    }

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("catName");
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String catName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parent;


//    @UpdateTimestamp
//    private Timestamp timestamp;

//    @Override
//    public Long getId() { return id; }
//    @Override
//    public void setId(Long id) { this.id = id; }

    public String getCatName() { return catName; }
    public void setCatName(String catName) { this.catName = catName; }

    public Category getParent() { return parent; }
    public void setParent(Category parent) { this.parent = parent; }

//    @Override
//    public Timestamp getTimestamp() {
//        return timestamp;
//    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", parentCategory=" + parent +
                '}';
    }
}
