package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics2.InterfaceSummaryProjection;

public interface XyzSummaryInterface extends InterfaceSummaryProjection<Xyz> {

    public Long getId();
    public String getXyzString();
    public String getName();
}
