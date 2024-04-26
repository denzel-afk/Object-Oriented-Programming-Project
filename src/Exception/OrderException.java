package exception;
<<<<<<< HEAD

/**
 * A custom exception class for handling errors related to undetermined orders.
 * 
=======
/**
 * A custom exception class for handling errors related to undetermined orders.
>>>>>>> 2478c428c8143fab2f7469d27ba246939d4d28dc
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
<<<<<<< HEAD

=======
>>>>>>> 2478c428c8143fab2f7469d27ba246939d4d28dc
	/**
	 * The constructor for the OrderException class.
	 * 
	 * @param message The error message.
	 */
	public OrderException(String message) {
		super(message);
	}
}
