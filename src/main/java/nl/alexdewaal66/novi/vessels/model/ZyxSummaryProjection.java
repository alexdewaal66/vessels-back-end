package nl.alexdewaal66.novi.vessels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import nl.alexdewaal66.novi.vessels.generics2.ClassSummaryProjection2;

@Data @AllArgsConstructor
public class ZyxSummaryProjection extends ClassSummaryProjection2<Zyx> {

    Long Id;
    String name;
}
