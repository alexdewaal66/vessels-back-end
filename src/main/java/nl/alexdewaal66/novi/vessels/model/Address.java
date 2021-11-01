package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.utils.Property;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Address implements GenericEntity<Address> {

    @Override
    @JsonIgnore
    @Transient
    public String getEntityName() {
        return "Address";
    }

    @Override
    @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("address1", "address2", "city", "postalCode");
    }

    private static final Object[][] propertyTupels = {
            {"id", Long.class},
            {"address1", String.class},
            {"address2", String.class},
            {"city", String.class},
            {"postalCode", String.class},
            {"country", Country.class}
    };

    static List<Property> properties = Property.makeList(propertyTupels);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 200)
    private String address1;

    @Size(max = 200)
    private String address2;

    @Size(max = 100)
    private String city;

    @Size(max = 20)
    private String postalCode;

    @ManyToOne
    private Country country;



    public void setId(Long id) { this.id = id; }
    @Override
    public Long getId() { return id; }
}
