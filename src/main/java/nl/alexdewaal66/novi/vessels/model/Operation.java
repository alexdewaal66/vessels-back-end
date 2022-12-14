package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSerializer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity @Getter @Setter @ToString
public class Operation extends BaseEntity<Operation>
{

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return null;
    }

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "vessel_id")
    Vessel vessel;

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    OperationType operationType;

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    @JoinColumn(name = "organisation_id")
    Organisation organisation;

    @Size(max = 1000)
    String description;
}
