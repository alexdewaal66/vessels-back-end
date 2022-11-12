package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSerializer;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity @ToString @NoArgsConstructor
public class Xyz extends BaseEntity<Xyz> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("xyzString", "name", "description");
    }


    @Size(max = 200)
    private String xyzString;

    @Size(max = 100)
    @Column(name = "item_name")
    private String name;

    @Size(max = 1000)
    private String description;

    @PositiveOrZero(message = "Negative ratios not allowed")
    private Double ratio = 0.0;

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    private Zyx zyx;

    @JsonSerialize(using = ItemIdSerializer.class)
    @OneToOne
    private Image image;


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

    public Image getImage() { return image; }
    public void setImage(Image image) { this.image = image; }

}
