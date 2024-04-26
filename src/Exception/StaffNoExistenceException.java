package exception;
<<<<<<< HEAD

=======
>>>>>>> 2478c428c8143fab2f7469d27ba246939d4d28dc
/**
 * A custom exception class for handling errors related to non-existing staff
 * login IDs.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */
<<<<<<< HEAD

public class StaffNoExistenceException extends Exception {
=======
public class StaffNoExistenceException extends Exception{
>>>>>>> 2478c428c8143fab2f7469d27ba246939d4d28dc
	/**
	 * The serial version UID.
	 */
	public StaffNoExistenceException() {
		super("Staff login ID does not exist");
	}
<<<<<<< HEAD

=======
>>>>>>> 2478c428c8143fab2f7469d27ba246939d4d28dc
	/**
	 * The constructor for the StaffNoExistenceException class.
	 * 
	 * @param message The error message.
	 */
	public StaffNoExistenceException(String message) {
		super(message);
	}

}
