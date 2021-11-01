package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Country implements GenericEntity<Country>{
//    @Override
//    public Country shallowCopy() {
//        Country copy = new Country();
//        copy.shortNameNL = this.shortNameNL;
//        copy.shortNameEN = this.shortNameEN;
//        copy.alpha2Code = this.alpha2Code;
//        copy.alpha3Code = this.alpha3Code;
//        copy.numericCode = this.numericCode;
//        return copy;
//    }

    @Override @JsonIgnore @Transient
    public String getEntityName() {
        return "Country";
    }

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("shortNameNL", "shortNameEN");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name_nl")
    private String shortNameNL;

    @Column(name = "short_name_en")
    private String shortNameEN;

    private String alpha2Code;

    private String alpha3Code;

    private String numericCode;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShortNameNL() { return shortNameNL; }
    public void setShortNameNL(String shortNameNL) { this.shortNameNL = shortNameNL; }

    public String getShortNameEN() { return shortNameEN; }
    public void setShortNameEN(String shortNameEN) { this.shortNameEN = shortNameEN; }

    public String getAlpha2Code() { return alpha2Code; }
    public void setAlpha2Code(String alpha2Code) { this.alpha2Code = alpha2Code; }

    public String getAlpha3Code() { return alpha3Code; }
    public void setAlpha3Code(String alpha3Code) { this.alpha3Code = alpha3Code; }

    public String getNumericCode() { return numericCode; }
    public void setNumericCode(String numericCode) { this.numericCode = numericCode; }
}
