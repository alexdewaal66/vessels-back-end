package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity @ToString
public class DBFile extends BaseEntity implements GenericEntity<DBFile> {

    @Override @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("fileName", "fileType");
    }

    @Size(max = 200)
    private String fileName;

    private String fileType;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] content;


    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public byte[] getContent() { return content; }
    public void setContent(byte[] content) { this.content = content; }

}
