package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface OrganisationSummary extends SummaryProjection<Organisation> {

    String getShortName();
}
