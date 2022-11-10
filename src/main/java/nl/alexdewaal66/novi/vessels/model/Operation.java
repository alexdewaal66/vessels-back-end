//package nl.alexdewaal66.novi.vessels.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.ToString;
//import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity @Getter @Setter
//public class Operation extends BaseEntity<Operation> {
//
//    @Override
//    @JsonIgnore
//    @Transient
//    public List<String> getTextProperties() {
//        return null;
//    }
//
//    @EmbeddedId
//    OperationKey id;
//
//    @ManyToOne
//    @MapsId("vesselId")
//    @JoinColumn(name = "vessel_id")
//    Vessel vessel;
//
//    @ManyToOne
//    @MapsId("operationTypeId")
//    @JoinColumn(name = "operation_type_id")
//    OperationType operationType;
//
//    @ManyToOne
//    @MapsId("organisationId")
//    @JoinColumn(name = "organisation_id")
//    Organisation organisation;
//}
