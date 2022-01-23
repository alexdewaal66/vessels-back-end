package nl.alexdewaal66.novi.vessels.generics2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassIdProjection2 <T extends GenericEntity2<T>>{
    private Long Id;
}
