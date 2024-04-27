package exception;

/**
 * A custom exception class for handling errors related to undetermined orders.
 * This exception is thrown when an order cannot be determined due to missing or
 * incomplete information.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class OrderException extends Exception {
	/**
	 * Constructs a new OrderException with the default message "Order is
	 * undetermined".
	 */
	public OrderException() {
		super("Order is undetermined");
	}

	/**
	 * Constructs a new OrderException with the specified detail message.
	 * 
	 * @param message The detail message (which is saved for later retrieval by the
	 *                getMessage() method).
	 */
	public OrderException(String message) {
		super(message);
	}
}