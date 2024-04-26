package exception;

/**
 * A custom exception class for handling errors related to existing branch
 * names.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class BranchExistsException extends Exception {
    /**
     * Constructs a new BranchExistsException with a default message. This exception
     * will be
     * shown when a branch's name already exists.
     */
    public BranchExistsException() {
        super("Branch's name already existed");
    }

    /**
     * Constructs a new BranchExistsException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the
     *                getMessage() method)
     */

    public BranchExistsException(String message) {
        super(message);
    }
}
