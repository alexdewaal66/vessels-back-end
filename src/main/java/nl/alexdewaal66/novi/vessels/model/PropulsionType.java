package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSerializer;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSetSerializer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @ToString
public class PropulsionType extends BaseEntity<PropulsionType> {

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

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "super_type_id")
    private PropulsionType superType;

    @JsonSerialize(using = ItemIdSetSerializer.class)
    @OneToMany(mappedBy = "superType")
    private Set<PropulsionType> subTypes = new HashSet<>();


    public String getNameNL() { return nameNL; }
    public void setNameNL(String nameNL) { this.nameNL = nameNL; }

    public String getNameEN() { return nameEN; }
    public void setNameEN(String nameEN) { this.nameEN = nameEN; }

    public String getDescNL() { return descNL; }
    public void setDescNL(String descNl) { this.descNL = descNl; }

    public String getDescEN() { return descEN; }
    public void setDescEN(String descEn) { this.descEN = descEn; }

    public PropulsionType getSuperType() { return superType; }
    public void setSuperType(PropulsionType superType) { this.superType = superType; }

    @JsonIgnore
    public Set<PropulsionType> getSubTypes() { return subTypes; }
    @JsonIgnore
    public void setSubTypes(Set<PropulsionType> subTypes) { this.subTypes = subTypes; }

}
