package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.utils.Property;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Hull implements GenericEntity<Hull> {

    @Override
    @JsonIgnore
    @Transient
    public String getEntityName() {
        return "Hull";
    }

    @Override
    @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("hullNumber", "builder");
    }

    private static final Object[][] propertyTupels = {
            {"id", Long.class},
            {"hullNumber", String.class},
            {"constructionDate", Date.class},
            {"builder", String.class}
    };

    static List<Property> properties = Property.makeList(propertyTupels);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private String hullNumber;

    @Temporal(value = TemporalType.DATE)
    private Date constructionDate;

    private String builder; //todo =»» @ManyToOne Organisation

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getHullNumber() {
        return hullNumber;
    }
    public void setHullNumber(String hullNumber) {
        this.hullNumber = hullNumber;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }
    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public String getBuilder() {
        return builder;
    }
    public void setBuilder(String builder) {
        this.builder = builder;
    }

    @Override
    public String toString() {
        return "Hull{" +
                "id=" + id +
                ", hullNumber='" + hullNumber + '\'' +
                ", constructionDate=" + constructionDate +
                ", builder='" + builder + '\'' +
                '}';
    }
}
