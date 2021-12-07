package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parent_category")
public class ParentCategory implements GenericEntity<ParentCategory> {

    @Override @JsonIgnore @Transient
    public String getEntityName() { return "ParentCategory"; }

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    @Override
    public String toString() {
        return "ParentCategory{" +
                "id=" + id +
                ", category=" + category +
                '}';
    }
}
