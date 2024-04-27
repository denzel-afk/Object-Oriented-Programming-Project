package exception;

/**
 * A custom exception class for handling errors related to adding staff.
 * 
 * This exception may be thrown when an attempt to add a staff member fails.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class AddStaffException extends Exception {

    /**
     * Constructs a new AddStaffException with a default message.
     * 
     * This exception will be called when a staff cannot be added.
     */
    public AddStaffException() {
        super("Staff cannot be added");
    }

    /**
     * Constructs a new AddStaffException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the
     *                getMessage() method)
     */
    public AddStaffException(String message) {
        super(message);
    }
}
