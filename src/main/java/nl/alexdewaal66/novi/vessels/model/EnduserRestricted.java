package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

import java.util.Collection;

public interface EnduserRestricted extends EnduserSummary {

    Collection<RoleSummary> getRoles();

}
