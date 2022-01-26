package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface HullSummary extends SummaryProjection<Hull> {

    Long getId();
    String getHullNumber();
}
