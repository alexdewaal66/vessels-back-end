package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.utils.Console;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Category implements GenericEntity<Category> {
    public Category() {
        Console.logv("Category » Category()");
    }

    public Category shallowCopy() {
        Category copy = new Category();
        copy.catName = this.catName;
        copy.parent = this.parent;
        return copy;
    }

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("catName");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String catName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parent;

    @Override public Long getId() { return id; }
    @Override public void setId(Long id) {
        Console.logv("Category » setId()", "id = " + id);
        this.id = id;
    }

    public String getCatName() { return catName; }
    public void setCatName(String catName) {
        Console.logv("Category » setCatName()",
                "catName = " + catName);
        this.catName = catName;
    }

    public Category getParent() { return parent; }
    public void setParent(Category parent) {
        Console.logv("Category » setParentCategory()",
                "parent = " + parent);
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", parentCategory=" + parent +
                '}';
    }
}
