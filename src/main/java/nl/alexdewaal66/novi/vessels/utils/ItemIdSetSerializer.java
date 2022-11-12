package nl.alexdewaal66.novi.vessels.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import java.io.IOException;
import java.util.Set;

public class ItemIdSetSerializer<T extends BaseEntity<T>>
        extends StdSerializer<Set<T>> {

    protected ItemIdSetSerializer() {
        super(Set.class, false);
    }

    @Override
    public void serialize(Set<T> tSet, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartArray();
        for (T value : tSet) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", value.getId());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }
}
