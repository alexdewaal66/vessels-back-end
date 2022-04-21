package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.alexdewaal66.novi.vessels.generics.BaseEntity;
import nl.alexdewaal66.novi.vessels.generics.GenericEntity;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity
public class DBFile extends BaseEntity implements GenericEntity<DBFile> {

//    public DBFile(String fileName, String fileType, byte[] content) {
//        this.fileName = fileName;
//        this.fileType = fileType;
//        this.content = content;
//    }

    @Override @JsonIgnore
    @Transient
    public List<String> getTextProperties() {
        return Arrays.asList("fileName", "fileType");
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Size(max = 200)
    private String fileName;

    private String fileType;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] content;

//    @UpdateTimestamp
//    private Timestamp timestamp;


//    @Override
//    public Long getId() { return id; }
//    @Override
//    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public byte[] getContent() { return content; }
    public void setContent(byte[] content) { this.content = content; }

//    @Override
//    public Timestamp getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "DBFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
