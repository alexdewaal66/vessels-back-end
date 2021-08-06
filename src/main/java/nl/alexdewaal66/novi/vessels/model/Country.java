package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String shortNameNl;

    @Column
    private String shortNameEn;

    @Column
    private String alpha2Code;

    @Column
    private String alpha3Code;

    @Column
    private String numericCode;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getShortNameNl() { return shortNameNl; }

    public void setShortNameNl(String shortNameNL) { this.shortNameNl = shortNameNL; }

    public String getShortNameEn() { return shortNameEn; }

    public void setShortNameEn(String shortNameEN) { this.shortNameEn = shortNameEN; }

    public String getAlpha2Code() { return alpha2Code; }

    public void setAlpha2Code(String alpha2Code) { this.alpha2Code = alpha2Code; }

    public String getAlpha3Code() { return alpha3Code; }

    public void setAlpha3Code(String alpha3Code) { this.alpha3Code = alpha3Code; }

    public String getNumericCode() { return numericCode; }

    public void setNumericCode(String numericCode) { this.numericCode = numericCode; }
}
