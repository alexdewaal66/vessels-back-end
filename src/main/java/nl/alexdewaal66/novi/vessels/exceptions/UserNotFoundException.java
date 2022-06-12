package nl.alexdewaal66.novi.vessels.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(Long id) {
        super("Cannot find user " + id);
    }

}
