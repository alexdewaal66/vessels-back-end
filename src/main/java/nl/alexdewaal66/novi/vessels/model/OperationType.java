//package nl.alexdewaal66.novi.vessels.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Transient;
//import javax.validation.constraints.Size;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//@Entity @Getter @Setter
//public class OperationType extends BaseEntity<OperationType> {
//    @Override @JsonIgnore @Transient
//    public List<String> getTextProperties() {
//        return Arrays.asList("nameNL", "nameEN", "descNL", "descEN");
//    }
//
//    @Size(max = 100)
//    @Column(name = "name_nl")
//    private String nameNL;
//
//    @Size(max = 100)
//    @Column(name = "name_en")
//    private String nameEN;
//
//    @Size(max = 1000)
//    @Column(name = "desc_nl")
//    private String descNL;
//
//    @Size(max = 1000)
//    @Column(name = "desc_en")
//    private String descEN;
//
//    @OneToMany(mappedBy = "operationType")
//    Set<Operation> operations;
//
//}
