package exception;

/**
 * A custom exception class for handling errors related to staff existence.
 * This exception is thrown when attempting to add a staff member with an ID
 * that already exists.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class StaffExistException extends Exception {
    /**
     * Constructs a new StaffExistException with the default message "Staff's ID
     * already existed".
     */
    public StaffExistException() {
        super("Staff's ID already existed");
    }

    /**
     * Constructs a new StaffExistException with the specified detail message.
     * 
     * @param message The detail message (which is saved for later retrieval by the
     *                getMessage() method).
     */
    public StaffExistException(String message) {
        super(message);
    }
}