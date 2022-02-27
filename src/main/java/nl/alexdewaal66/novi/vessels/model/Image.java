package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import nl.alexdewaal66.novi.vessels.repository.DBFileRepository;
import nl.alexdewaal66.novi.vessels.utils.Console;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@ToString
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

    @Column(name = "full_size_copy")
    private Long fullSizeId;

    @Column(name = "thumbnail_copy")
    private Long thumbnailId;

    @UpdateTimestamp
    private Timestamp timestamp;

    @Override
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public DBFile getFullSize() {
        return fullSize;
    }
    public void setFullSize(DBFile fullSize) {
        this.fullSize = fullSize;
        this.fullSizeId = fullSize.getId();
    }

    public DBFile getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(DBFile thumbnail) {
        this.thumbnail = thumbnail;
        this.thumbnailId = thumbnail.getId();
    }

    public Long getFullSizeId() {
        return fullSizeId;
    }
    public void setFullSizeId(Long id) {
        Console.logv("Image » setFullSizeId()", "id=" + id);
        if (fullSize == null) {
            fullSize = new DBFile();
        }
        fullSize.setId(id);
        fullSizeId = id;
    }

    public Long getThumbnailId() {
        return thumbnailId;
    }
    public void setThumbnailId(Long id) {
        Console.logv("Image » setThumbnailId()", "id=" + id);
        if (thumbnail == null) {
            thumbnail = new DBFile();
        }
        thumbnail.setId(id);
        thumbnailId = id;
    }
}
