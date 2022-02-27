package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface SubdivisionSummary extends SummaryProjection<Subdivision> {

    String getName();
    String getAlpha2Code();
    String getSubdivisionCode();
}
