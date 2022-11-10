package nl.alexdewaal66.novi.vessels.infrastructure.dummy;

import lombok.Getter;
import lombok.Setter;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.List;

/////// dummy entity for testing purposes //////////////
@Entity
@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
public
class Dummy extends BaseEntity<Dummy> {

    public Dummy() {}

    @Override
    public List<String> getTextProperties() {
        return null;
    }

    private String dummyName;

    public Dummy(Long id, Timestamp timestamp, String owner, String updater, String dummyName) {
        this.id = id;
        this.timestamp = timestamp;
        this.owner = owner;
        this.updater = updater;
        this.dummyName = dummyName;
    }

}
