package exception;

/**
 * A custom exception class for handling errors related to non-existing staff
 * login IDs.
 * This exception is thrown when attempting to access a staff member with a
 * login ID that does not exist.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class StaffNoExistenceException extends Exception {
	/**
	 * Constructs a new StaffNoExistenceException with the default message "Staff
	 * login ID does not exist".
	 */
	public StaffNoExistenceException() {
		super("Staff login ID does not exist");
	}

	/**
	 * Constructs a new StaffNoExistenceException with the specified detail message.
	 * 
	 * @param message The detail message (which is saved for later retrieval by the
	 *                getMessage() method).
	 */
	public StaffNoExistenceException(String message) {
		super(message);
	}

}