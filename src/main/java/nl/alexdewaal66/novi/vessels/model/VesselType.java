package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.*;
//import nl.alexdewaal66.novi.vessels.config.SpringConfiguration;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @ToString
public class VesselType extends BaseEntity implements GenericEntity<VesselType> {

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

    @PositiveOrZero(message = "Negative tonnage not allowed")
    private Integer tonnageMin;

    @PositiveOrZero(message = "Negative tonnage not allowed")
    private Integer tonnageMax;

    @PositiveOrZero(message = "Negative length not allowed")
    private Double length;

    @PositiveOrZero(message = "Negative beam not allowed")
    private Double beam;

    @PositiveOrZero(message = "Negative height not allowed")
    private Double height;

    @PositiveOrZero(message = "Negative draft not allowed")
    private Double draft;

    @ManyToOne
    @JoinColumn(name = "super_type_id")
    private VesselType superType;

    @OneToMany(mappedBy = "superType")
    private Set<VesselType> subTypes = new HashSet<>();


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

    public Integer getTonnageMin() {
        return tonnageMin;
    }
    public void setTonnageMin(Integer tonnageMin) {
        this.tonnageMin = tonnageMin;
    }

    public Integer getTonnageMax() {
        return tonnageMax;
    }
    public void setTonnageMax(Integer tonnageMax) {
        this.tonnageMax = tonnageMax;
    }

    public Double getLength() {
        return length;
    }
    public void setLength(Double length) {
        this.length = length;
    }

    public Double getBeam() {
        return beam;
    }
    public void setBeam(Double beam) {
        this.beam = beam;
    }

    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDraft() {
        return draft;
    }
    public void setDraft(Double draft) {
        this.draft = draft;
    }

    public VesselType getSuperType() {
        return superType;
    }
    public void setSuperType(VesselType superType) { this.superType = superType; }

    @JsonIgnore
    public Set<VesselType> getSubTypes() {
        return subTypes;
    }
    @JsonIgnore
    public void setSubTypes(Set<VesselType> subTypes) {
        this.subTypes = subTypes;
    }

}

