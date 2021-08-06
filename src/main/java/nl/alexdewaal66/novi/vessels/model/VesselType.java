package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class VesselType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 100)
    private String nameNl;

    @Size(max = 100)
    private String nameEn;

    @Size(max = 1000)
    private String descNl;

    @Size(max = 1000)
    private String descEn;

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
    private VesselType parentType;

    @OneToMany(mappedBy = "parentType")
    private Set<VesselType> subTypes = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameNl() {
        return nameNl;
    }

    public void setNameNl(String nameNl) {
        this.nameNl = nameNl;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getDescNl() {
        return descNl;
    }

    public void setDescNl(String descNl) {
        this.descNl = descNl;
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
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

    public VesselType getParentType() {
        return parentType;
    }

    public void setParentType(VesselType parentType) {
        this.parentType = parentType;
    }

    public Set<VesselType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(Set<VesselType> subTypes) {
        this.subTypes = subTypes;
    }
}

