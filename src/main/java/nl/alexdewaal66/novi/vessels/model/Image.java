package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Image implements GenericEntity<Image> {

    @Override
    @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    private DBFile fullSize;

    @JsonIgnore
    @OneToOne
    private DBFile thumbnail;

    @Override
    public Long getId() { return id; }
    @Override
    public void setId(Long id) { this.id = id; }

    public DBFile getFullSize() { return fullSize; }
    public void setFullSize(DBFile fullSize) { this.fullSize = fullSize; }

    public DBFile getThumbnail() { return thumbnail; }
    public void setThumbnail(DBFile thumbnail) { this.thumbnail = thumbnail; }

    public Long getFullSizeId() { return fullSize.getId(); }

    public Long getThumbnailId() { return thumbnail.getId(); }
}
