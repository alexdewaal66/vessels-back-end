package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface VesselTypeSummary extends SummaryProjection<VesselType> {

    Long getId();
    String getNameNL();
    String getNameEN();

}
