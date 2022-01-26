package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface AddressSummary extends SummaryProjection<Address> {

    // 'id', 'address1', 'address2', 'city', 'country.alpha2Code'
    Long getId();
    String getAddress1();
    String getAddress2();
    String getCity();
    CountryCode getCountry();

    interface CountryCode {
        Long getId();
        String getAlpha2Code();
    }

}
