package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@Entity @ToString
public class DBFile extends BaseEntity<DBFile> {

    @Override @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("fileName", "fileType");
    }

    @Size(max = 200)
    private String fileName;

    private String fileType;

    @Lob @JsonIgnore
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] content;

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public byte[] getContent() { return content; }
    public void setContent(byte[] content) { this.content = content; }


}
