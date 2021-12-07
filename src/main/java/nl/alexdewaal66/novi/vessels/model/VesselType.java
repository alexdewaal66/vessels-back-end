package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.*;
//import nl.alexdewaal66.novi.vessels.config.SpringConfiguration;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class VesselType implements GenericEntity<VesselType> {
    public VesselType() {
    }

    public VesselType shallowCopy() {
        VesselType copy = new VesselType();
        copy.nameNL = this.nameNL;
        copy.nameEN = this.nameEN;
        copy.descNL = this.descNL;
        copy.descEN = this.descEN;
        copy.tonnageMin = this.tonnageMin;
        copy.tonnageMax = this.tonnageMax;
        copy.length = this.length;
        copy.beam = this.beam;
        copy.height = this.height;
        copy.draft = this.draft;
        copy.superType = this.superType;
        return copy;
    }

    @Override
    @JsonIgnore
    @Transient
    public String getEntityName() {
        return "VesselType";
    }

    @Override
    @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("nameNL", "nameEN", "descNL", "descEN");
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    //    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "super_type_id", nullable = true)
    private VesselType superType;

    @OneToMany(mappedBy = "superType")
    private Set<VesselType> subTypes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setSuperType(VesselType superType) {
        this.superType = superType;
    }
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
//    @JsonProperty("superType")
//    public void setSuperType(Long id) {
//        this.superType = entityManager.getReference(VesselType.class, id);
//    }

    @JsonIgnore
    public Set<VesselType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(Set<VesselType> subTypes) {
        this.subTypes = subTypes;
    }

    @Override
    public String toString() {
        return "VesselType{" +
                "id=" + id +
                ", nameNL='" + nameNL + '\'' +
                ", nameEN='" + nameEN + '\'' +
                ", descNL='" + descNL + '\'' +
                ", descEN='" + descEN + '\'' +
                ", tonnageMin=" + tonnageMin +
                ", tonnageMax=" + tonnageMax +
                ", length=" + length +
                ", beam=" + beam +
                ", height=" + height +
                ", draft=" + draft +
                ", superType=" + superType +
                '}';
    }
}

