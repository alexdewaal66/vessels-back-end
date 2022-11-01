package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity @ToString
public class Address extends BaseEntity<Address> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("address1", "address2", "city", "postalCode");
    }

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


    public String getAddress1() {return address1;}
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

}
