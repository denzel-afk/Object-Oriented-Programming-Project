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
	public MenuException() {
		super("Menu does not exist!");
	}

	public MenuException(String message) {
		super(message);
	}
}