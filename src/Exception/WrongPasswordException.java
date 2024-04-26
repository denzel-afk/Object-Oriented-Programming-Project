package exception;

/**
 * A custom exception class for handling errors related to wrong password input.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */
public class WrongPasswordException extends Exception {
    /**
     * Default constructor for WrongPasswordException.
     */
    public WrongPasswordException() {
        super("Your new password is the same as the old password/invalid. Please enter a different password.");
    }

    /**
     * Constructor for WrongPasswordException with a custom message.
     * 
     * @param message The custom message for the exception.
     */
    public WrongPasswordException(String message) {
        super(message);
    }
}
