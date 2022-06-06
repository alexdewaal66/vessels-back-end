package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity @ToString
public class Relation extends BaseEntity<Relation> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return null;
    }


    @ManyToOne
    @JoinColumn(name = "organisation1_id")
    Organisation organisation1;

    @ManyToOne
    RelationType relationType;

    @ManyToOne
    @JoinColumn(name = "organisation2_id")
    Organisation organisation2;


    public Organisation getOrganisation1() { return organisation1; }
    public void setOrganisation1(Organisation organisation1) { this.organisation1 = organisation1; }

    public Organisation getOrganisation2() { return organisation2; }
    public void setOrganisation2(Organisation organisation2) { this.organisation2 = organisation2; }

    public RelationType getRelationType() { return relationType; }
    public void setRelationType(RelationType relationType) { this.relationType = relationType; }

}
