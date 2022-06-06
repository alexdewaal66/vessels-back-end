package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface XyzSummary extends SummaryProjection<Xyz> {

    String getXyzString();
    String getName();
}
