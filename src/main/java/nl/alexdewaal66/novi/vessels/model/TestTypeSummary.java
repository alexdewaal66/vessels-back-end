package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface TestTypeSummary extends SummaryProjection<TestType>{

    String getNameNL();
    String getNameEN();

}
