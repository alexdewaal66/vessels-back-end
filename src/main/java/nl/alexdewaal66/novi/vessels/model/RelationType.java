package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/*
'id', 'nameNL', 'nameEN'
 */

@Entity
public class RelationType extends BaseEntity implements GenericEntity<RelationType> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("nameNL", "nameEN", "descNL", "descEN");
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

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


//    @UpdateTimestamp
//    private Timestamp timestamp;


//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }

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

//    @Override
//    public Timestamp getTimestamp() {
//        return timestamp;
//    }
//

    @Override
    public String toString() {
        return "RelationType{" +
                "id=" + id +
                ", nameNL='" + nameNL + '\'' +
                ", nameEN='" + nameEN + '\'' +
                ", descNL='" + descNL + '\'' +
                ", descEN='" + descEN + '\'' +
                '}';
    }
}

/*
lidmaatschap / membership
eigendom / ownership

 */