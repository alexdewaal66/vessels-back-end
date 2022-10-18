package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface RoleSummary extends SummaryProjection<Role> {
    String getName();
}
