package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Country2 implements GenericEntity{
    @Override
    public String getEntityName() {
        return "Country2";
    }

    @Override
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

    @Override
    public Long getId() { return id; }
    @Override
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
