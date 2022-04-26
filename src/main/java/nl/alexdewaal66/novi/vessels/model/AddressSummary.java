package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

import java.sql.Timestamp;

public interface AddressSummary extends SummaryProjection<Address> {

    String getAddress1();
    String getAddress2();
    String getCity();
    CountryCode getCountry();

    interface CountryCode {
        Long getId();
        String getAlpha2Code();
    }

}
