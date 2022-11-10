package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity @ToString
public class RelationType extends BaseEntity<RelationType> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("nameNL", "nameEN", "descNL", "descEN");
    }

    @Size(max = 100)
    @Column(name = "name_nl")
    private String nameNL;

    @Size(max = 100)
    @Column(name = "name_en")
    private String nameEN;

    @Size(max = 1000)
    @Column(name = "desc_nl")
    private String descNL;

    @Size(max = 1000)
    @Column(name = "desc_en")
    private String descEN;


    public String getNameNL() {
        return nameNL;
    }
    public void setNameNL(String nameNL) {
        this.nameNL = nameNL;
    }

    public String getNameEN() {
        return nameEN;
    }
    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getDescNL() {
        return descNL;
    }
    public void setDescNL(String descNl) {
        this.descNL = descNl;
    }

    public String getDescEN() {
        return descEN;
    }
    public void setDescEN(String descEn) {
        this.descEN = descEn;
    }

}
