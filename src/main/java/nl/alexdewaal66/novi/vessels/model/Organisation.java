package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
import nl.alexdewaal66.novi.vessels.utils.ItemIdSerializer;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity @ToString
public class Organisation extends BaseEntity<Organisation> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("shortName", "longName", "description", "url", "email");
    }


    @Size(max = 50)
    private String shortName;

    @Size(max = 200)
    private String longName;

    @Size(max = 1000)
    private String description;

    @Size(max = 2000)
    private String url;

    @Size(max = 320)
    private String email;

    @JsonSerialize(using = ItemIdSerializer.class)
    @ManyToOne
    private Address address;

    @OneToMany(mappedBy = "organisation")
    Set<Operation> operations;

    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Operation> getOperations() {return operations;}
    public void setOperations(Set<Operation> operations) {this.operations = operations;}

}
