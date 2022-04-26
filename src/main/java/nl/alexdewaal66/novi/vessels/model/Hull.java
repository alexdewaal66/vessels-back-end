package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity @ToString
public class Hull extends BaseEntity implements GenericEntity<Hull> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("hullNumber", "builder");
    }


    @Size(max = 20)
    private String hullNumber;

    @Temporal(value = TemporalType.DATE)
    private Date constructionDate;

    private String builder; //todo =»» @ManyToOne Organisation

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

}
