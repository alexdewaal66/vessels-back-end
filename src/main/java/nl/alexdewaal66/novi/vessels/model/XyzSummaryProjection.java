package nl.alexdewaal66.novi.vessels.model;

import lombok.Value;
import nl.alexdewaal66.novi.vessels.generics2.ClassSummaryProjection2;

@Value
public class XyzSummaryProjection extends ClassSummaryProjection2<Xyz> {

    Long id;
    String xyzString;
    String name;

}