package exception;

/**
 * A custom exception class for handling errors related to adding staff.
 * 
 * @author Denzel Elden Wijaya
 * @version 1.0
 * @since 2024-04-26
 */
public class AddStaffException extends Exception {

    /**
     * Constructs a new AddStaffException with a default message, where this
     * exception will be called
     * when a staff can not be added.
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
