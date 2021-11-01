package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Category implements GenericEntity<Category> {
    public Category() {
    }

    @Override @JsonIgnore @Transient
    public String getEntityName() {
        return "Category";
    }

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("catName");
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String catName;

    @Column(name = "parent_id")
    private Long parentId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCatName() { return catName; }
    public void setCatName(String catName) { this.catName = catName; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
