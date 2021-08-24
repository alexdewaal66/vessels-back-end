package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Xyz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 200)
    private String xyzString;

    @Size(max = 100)
    @Column(name = "item_name")
    private String name;

    @Size(max = 1000)
    private String description;

    @PositiveOrZero(message = "Negative ratios not allowed")
    private Double ratio = 0.0;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getXyzString() { return xyzString; }

    public void setXyzString(String xyz) { this.xyzString = xyz; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String desc) { this.description = desc; }

    public double getRatio() { return (ratio != null) ? ratio : 0.0; }

    public void setRatio(double ratio) { this.ratio = ratio; }

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
