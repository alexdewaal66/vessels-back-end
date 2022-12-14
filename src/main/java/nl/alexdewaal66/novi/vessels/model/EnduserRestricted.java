package nl.alexdewaal66.novi.vessels.model;

import java.util.Collection;

public interface EnduserRestricted extends EnduserSummary {

    Collection<RoleSummary> getRoles();

}
