package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface VesselTypeSummary extends SummaryProjection<VesselType> {

    String getNameNL();
    String getNameEN();

}
