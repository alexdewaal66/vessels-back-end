package nl.alexdewaal66.novi.vessels.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Zyx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 100)
    @Column(name = "item_name")
    private String name;

    @Size(max = 1000)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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