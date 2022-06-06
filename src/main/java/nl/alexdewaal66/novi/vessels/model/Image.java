package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity @ToString
public class Image extends BaseEntity<Image> {

    @Override @JsonIgnore @Transient
    public List<String> getTextProperties() {
        return null;
    }


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
//        Console.logv("Image » setFullSizeId()", "id=" + id);
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
//        Console.logv("Image » setThumbnailId()", "id=" + id);
        if (thumbnail == null) {
            thumbnail = new DBFile();
        }
        thumbnail.setId(id);
        thumbnailId = id;
    }

}
