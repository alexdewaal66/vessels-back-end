package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.repository.DBFileRepository;
import nl.alexdewaal66.novi.vessels.utils.Console;

import javax.persistence.*;
import java.util.List;

@Entity @ToString
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
    public void setFullSizeId(Long id) {
        Console.logv("Image » setFullSizeId()", "id=" + id);
//        if (id == null) {
//            id = 0L;
//        }
        if (fullSize == null) {
            fullSize = new DBFile();
        }
        fullSize.setId(id);
    }

    public Long getThumbnailId() { return thumbnail.getId(); }
    public void setThumbnailId(Long id) {
        Console.logv("Image » setThumbnailId()", "id=" + id);
//        if (id == null) {
//            id = 0L;
//        }
        if (thumbnail == null) {
            thumbnail = new DBFile();
        }
        thumbnail.setId(id);
    }
}
