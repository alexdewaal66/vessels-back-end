package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.utils.Property;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Xyz implements GenericEntity{
    public static final String entityName = "Xyz";
    public static final List<String> textProperties =
            Arrays.asList("xyzString", "name", "description");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 200)
    private String xyzString;

    @Size(max = 100)
    @Column(name = "item_name")
    private String name;

    @Size(max = 1000)
    private String description;

    @PositiveOrZero(message = "Negative ratios not allowed")
    private Double ratio = 0.0;

    @ManyToOne
            // (cascade = CascadeType.PERSIST)
    private Zyx zyx;

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {

    }

    public void setId(long id) { this.id = id; }

    public String getXyzString() { return xyzString; }

    public void setXyzString(String xyz) { this.xyzString = xyz; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String desc) { this.description = desc; }

    public double getRatio() { return (ratio != null) ? ratio : 0.0; }

    public void setRatio(double ratio) { this.ratio = ratio; }

    public Zyx getZyx() { return zyx; }

    public void setZyx(Zyx zyx) { this.zyx = zyx; }

    @Override
    public String toString() {
        return "Xyz{" +
                "id=" + id +
                ", xyzString='" + xyzString + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ratio=" + ratio +
                '}';
    }
}
