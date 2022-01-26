package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface RelationTypeSummary  extends SummaryProjection<RelationType> {

    Long getId();
    String getNameNL();
    String getNameEN();
}

