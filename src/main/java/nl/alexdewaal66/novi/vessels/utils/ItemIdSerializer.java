package nl.alexdewaal66.novi.vessels.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import java.io.IOException;

public class ItemIdSerializer<T extends BaseEntity<T>> extends StdSerializer<T> {

    public ItemIdSerializer() {
        this(null);
    }

    public ItemIdSerializer(Class<T> t) {
        super(t);
    }

//    @Override
    public void serialize(
            T value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeEndObject();
    }

}
