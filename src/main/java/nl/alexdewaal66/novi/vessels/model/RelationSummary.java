package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface RelationSummary extends SummaryProjection<Relation> {

    Long getId();
    OrgName getOrganisation1();
    OrgName getOrganisation2();

    interface OrgName {
        String getShortName();
    }
}
