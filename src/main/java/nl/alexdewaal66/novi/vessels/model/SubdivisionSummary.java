package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface SubdivisionSummary extends SummaryProjection<Subdivision> {

    String getName();
    String getAlpha2Code();
    String getSubdivisionCode();
}
