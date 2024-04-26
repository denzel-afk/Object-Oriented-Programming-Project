package exception;
/**
 * A custom exception class for handling errors related to undetermined orders.
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */
public class OrderException extends Exception {
	/**
	 * The serial version UID.
	 */
	public OrderException() {
		super("Order is undetermined");
	}
	/**
	 * The constructor for the OrderException class.
	 * 
	 * @param message The error message.
	 */
	public OrderException(String message) {
		super(message);
	}
}
