package nl.alexdewaal66.novi.vessels.exceptions;

import java.io.IOException;

public class FileStorageException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FileStorageException() {
        super();
    }

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, IOException ex) {
        super(message, ex);
    }
}
