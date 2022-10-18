package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

import java.util.Collection;

public interface EnduserSummary extends SummaryProjection<Enduser> {
    String getUsername();
}
