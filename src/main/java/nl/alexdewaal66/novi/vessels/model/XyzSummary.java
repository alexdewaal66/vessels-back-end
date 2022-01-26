package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface XyzSummary extends SummaryProjection<Xyz> {

    Long getId();
    String getXyzString();
    String getName();
}
