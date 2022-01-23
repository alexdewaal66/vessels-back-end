package nl.alexdewaal66.novi.vessels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.alexdewaal66.novi.vessels.generics2.ClassSummaryProjection2;

@Data @AllArgsConstructor
public class XyzSummaryProjection extends ClassSummaryProjection2<Xyz> {

    Long id;
    String xyzString;
    String name;

}