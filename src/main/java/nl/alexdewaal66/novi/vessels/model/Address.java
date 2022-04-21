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
public class Address extends BaseEntity implements GenericEntity<Address> {
    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("address1", "address2", "city", "postalCode");
    }

//    private static final Object[][] propertyTupels = {
//            {"id", Long.class},
//            {"address1", String.class},
//            {"address2", String.class},
//            {"city", String.class},
//            {"postalCode", String.class},
//            {"country", Country.class}
//    };

//    static List<Property> properties = Property.makeList(propertyTupels);

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Size(max = 200)
    private String address1;

    @Size(max = 200)
    private String address2;

    @Size(max = 100)
    private String city;

    @Size(max = 20)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

//    @UpdateTimestamp
//    private Timestamp timestamp;

//    @Override
//    public Long getId() { return id; }
//    @Override
//    public void setId(Long id) { this.id = id; }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

//    @Override
//    public Timestamp getTimestamp() {
//        return timestamp;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                '}';
    }
}
