package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface CountrySummary  extends SummaryProjection<Country> {

    Long getId();
    String getShortNameNL();
    String getAlpha2Code();
    String getAlpha3Code();
}
