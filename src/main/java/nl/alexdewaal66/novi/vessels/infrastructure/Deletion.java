package nl.alexdewaal66.novi.vessels.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity @ToString
public class Deletion {

    @Id @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private String entityName;
    private Long itemId;
    @CreationTimestamp
    private Timestamp timestamp;

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public String getEntityName() {return entityName;}
    public void setEntityName(String entityName) {this.entityName = entityName;}

    public Long getItemId() {return itemId;}
    public void setItemId(Long itemId) {this.itemId = itemId;}

    public Timestamp getTimestamp() {return timestamp;}
    public void setTimestamp(Timestamp timestamp) {this.timestamp = timestamp;}

}
