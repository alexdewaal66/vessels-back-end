package nl.alexdewaal66.novi.vessels.exceptions;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String entity, long id) {
        super("Cannot find " + entity + ": " + id);
    }
}