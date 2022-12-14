package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;

@Entity @ToString
public class Subdivision extends BaseEntity<Subdivision> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("alpha2Code", "subdivisionCode", "name", "type");
    }


    @Size(max = 2)
    private String alpha2Code;

    @Size(max = 3)
    @Column(name = "subdivision_code")
    private String subdivisionCode;

    @Size(max = 150)
    @Column(name = "subdivision_name")
    private String name;

    @Size(max = 100)
    @Column(name = "subdivision_type")
    private String type;


    public String getAlpha2Code() {
        return alpha2Code;
    }
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getSubdivisionCode() {
        return subdivisionCode;
    }
    public void setSubdivisionCode(String code) {
        this.subdivisionCode = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
