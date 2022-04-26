package nl.alexdewaal66.novi.vessels.service;

import nl.alexdewaal66.novi.vessels.exceptions.FileStorageException;
import nl.alexdewaal66.novi.vessels.generics.GenericServiceImpl;
import nl.alexdewaal66.novi.vessels.model.DBFile;
import nl.alexdewaal66.novi.vessels.repository.DBFileRepository;
import nl.alexdewaal66.novi.vessels.utils.Console;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class DBFileServiceImpl
        extends GenericServiceImpl<DBFile>
        implements DBFileService {

    public DBFileServiceImpl(DBFileRepository repository) {
        super(repository);
    }

    public DBFile convertFile(MultipartFile mpFile) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(mpFile.getOriginalFilename()));

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Filename contains invalid path sequence: " + fileName);
            }
            DBFile dbFile = new DBFile();
            dbFile.setFileName(fileName);
            dbFile.setFileType(mpFile.getContentType());
            dbFile.setContent(mpFile.getBytes());

            return dbFile;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    public Long create(MultipartFile mpFile) {
        DBFile dbFile = repository.save(convertFile(mpFile));
        return dbFile.getId();
    }

}
