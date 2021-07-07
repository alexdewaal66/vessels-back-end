package nl.alexdewaal66.novi.vessels.exceptions;

public class UsernameExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

//    public UsernameExistsException() {
//        super();
//    }

    public UsernameExistsException(String username) {
        super("User " + username + " exists.");
    }
}
