package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface RelationSummary extends SummaryProjection<Relation> {

    OrgName getOrganisation1();
    OrgName getOrganisation2();

    interface OrgName {
        String getShortName();
    }
}
