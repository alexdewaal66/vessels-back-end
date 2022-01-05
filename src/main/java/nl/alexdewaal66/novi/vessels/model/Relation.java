package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Relation implements GenericEntity<Relation> {

    @Override
    @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organisation1_id")
    Organisation organisation1;

    @ManyToOne
    RelationType relationType;

    @ManyToOne
    @JoinColumn(name = "organisation2_id")
    Organisation organisation2;

    @Override
    public Long getId() { return id; }
    @Override
    public void setId(Long id) { this.id = id; }

    public Organisation getOrganisation1() { return organisation1; }
    public void setOrganisation1(Organisation organisation1) { this.organisation1 = organisation1; }

    public Organisation getOrganisation2() { return organisation2; }
    public void setOrganisation2(Organisation organisation2) { this.organisation2 = organisation2; }

    public RelationType getRelationType() { return relationType; }
    public void setRelationType(RelationType relationType) { this.relationType = relationType; }
}
