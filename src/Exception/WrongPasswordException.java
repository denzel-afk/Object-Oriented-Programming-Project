package exception;

/**
 * A custom exception class for handling errors related to wrong password input.
 * This exception is thrown when an attempt is made to change the password to a
 * value that is the same as the old password or invalid.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class WrongPasswordException extends Exception {
    /**
     * Constructs a new WrongPasswordException with the default message.
     * The default message advises the user to enter a different password as the new
     * password is the same as the old password or invalid.
     */
    public WrongPasswordException() {
        super("Your new password is the same as the old password/invalid. Please enter a different password.");
    }

    /**
     * Constructs a new WrongPasswordException with the specified detail message.
     * 
     * @param message The detail message (which is saved for later retrieval by the
     *                getMessage() method).
     */
    public WrongPasswordException(String message) {
        super(message);
    }
}