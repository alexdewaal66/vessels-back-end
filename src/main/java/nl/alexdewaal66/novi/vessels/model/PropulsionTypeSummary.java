package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface PropulsionTypeSummary extends SummaryProjection<PropulsionType> {

    String getNameNL();
    String getNameEN();

}
