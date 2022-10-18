package nl.alexdewaal66.novi.vessels.model;


import com.fasterxml.jackson.annotation.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @ToString @NoArgsConstructor
public class TestType extends BaseEntity<TestType>{

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

//    @Column(name = "length_oa")
//    @PositiveOrZero(message = "Negative length not allowed")
//    private Double lengthOA;
//
//    @PositiveOrZero(message = "Negative beam not allowed")
//    private Double beam;
//
//    @PositiveOrZero(message = "Negative height not allowed")
//    private Double height;

    @PositiveOrZero(message = "Negative draft not allowed")
    private Double draft;

    @ManyToOne
    @JoinColumn(name = "super_type_id")
    private TestType superType;

    @OneToMany(mappedBy = "superType")
    private Set<TestType> subTypes = new HashSet<>();


    public String getNameNL() {return nameNL;}
    public void setNameNL(String nameNL) {this.nameNL = nameNL;}

    public String getNameEN() {return nameEN;}
    public void setNameEN(String nameEN) {this.nameEN = nameEN;}

    public String getDescNL() {return descNL;}
    public void setDescNL(String descNl) {this.descNL = descNl;}

    public String getDescEN() {return descEN;}
    public void setDescEN(String descEn) {this.descEN = descEn;}


//    public Double getLengthOA() {return lengthOA;}
//    public void setLengthOA(Double length) {this.lengthOA = length;}
//
//    public Double getBeam() {return beam;}
//    public void setBeam(Double beam) {this.beam = beam;}
//
//    public Double getHeight() {return height;}
//    public void setHeight(Double height) {this.height = height;}

    public Double getDraft() {return draft;}
    public void setDraft(Double draft) {this.draft = draft;}

    public TestType getSuperType() {return superType;}
    public void setSuperType(TestType superType) { this.superType = superType; }

    @JsonIgnore
    public Set<TestType> getSubTypes() {return subTypes;}
    @JsonIgnore
    public void setSubTypes(Set<TestType> subTypes) {this.subTypes = subTypes;}


}
