package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;

@Entity
public class Pqr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String pqrString;

    @Column(name = "item_name")
    private String name;

    @Column
    private String description;

    @Column
    private Double ratio = 0.0;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPqrString() { return pqrString; }

    public void setPqrString(String pqr) { this.pqrString = pqr; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String desc) { this.description = desc; }

    public double getRatio() { return (ratio != null) ? ratio : 0.0; }

    public void setRatio(double ratio) { this.ratio = ratio; }
}
