package nl.alexdewaal66.novi.vessels.generics;

import nl.alexdewaal66.novi.vessels.model.User;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @UpdateTimestamp
    protected Timestamp timestamp;

    protected String owner;

    protected String updater;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public String getUpdater() { return updater; }
    public void setUpdater(String updater) { this.updater = updater; }
}
