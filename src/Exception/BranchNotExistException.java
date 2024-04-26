package exception;

/**
 * A custom exception class for handling errors related to non-existing branch
 * names.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */

public class BranchNotExistException extends Exception {
    /**
     * Constructs a new BranchNotExistException with a default message. This
     * exception
     * will be
     * shown when a branch's name does not exist.
     */
    public BranchNotExistException() {
        super("Branch does not exist");
    }

    /**
     * Constructs a new BranchNotExistException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the
     *                getMessage() method)
     */

    public BranchNotExistException(String message) {
        super(message);
    }
}
