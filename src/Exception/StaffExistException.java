package exception;

/**
 * A custom exception class for handling errors related to staff existence.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */
public class StaffExistException extends Exception {
    /**
     * The serial version UID.
     */
    public StaffExistException() {
        super("Staff's ID already existed");
    }

    /**
     * The constructor for the StaffExistException class.
     * 
     * @param message The error message.
     */
    public StaffExistException(String message) {
        super(message);
    }
}