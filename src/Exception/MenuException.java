package exception;

/**
 * A custom exception class for handling errors related to non-existing menu
 * names.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */

public class MenuException extends Exception {
	/**
	 * Constructs a new MenuException with a default message. This exception will be
	 * shown when a menu's name does not exist.
	 */
	public MenuException() {
		super("Menu does not exist!");
	}

	/**
	 * Constructs a new MenuException with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                getMessage() method)
	 */
	public MenuException(String message) {
		super(message);
	}
}
