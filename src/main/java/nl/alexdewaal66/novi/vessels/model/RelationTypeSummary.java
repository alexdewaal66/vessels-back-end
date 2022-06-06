package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface RelationTypeSummary  extends SummaryProjection<RelationType> {

    String getNameNL();
    String getNameEN();
}

