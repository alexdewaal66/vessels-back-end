package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface OrganisationSummary extends SummaryProjection<Organisation> {

    Long getId();
    String getShortName();
}
