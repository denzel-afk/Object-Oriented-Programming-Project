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
	public OrderException() {
		super("Order is undetermined");
	}

	public OrderException(String message) {
		super(message);
	}
}
