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

@Entity
public class Organisation extends BaseEntity implements GenericEntity<Organisation> {
    public Organisation() {
    }

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("shortName", "longName", "description", "url", "email");
    }

//    private static final Object[][] propertyTupels = {
//            {"id", Long.class},
//            {"shortName", String.class},
//            {"longName", String.class},
//            {"description", String.class},
//            {"url", String.class},
//            {"email", Country.class},
//            {"address", Address.class}
//    };

//    static List<Property> properties = Property.makeList(propertyTupels);

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

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

    @ManyToOne
    private Address address;


//    @UpdateTimestamp
//    private Timestamp timestamp;


//    @Override
//    public Long getId() { return id; }
//    @Override
//    public void setId(Long id) { this.id = id; }

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

//    @Override
//    public Timestamp getTimestamp() {
//        return timestamp;
//    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", shortName='" + shortName + '\'' +
                ", longName='" + longName + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
