package exception;
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
public class StaffNoExistenceException extends Exception{
	public StaffNoExistenceException() {
		super("Staff login ID does not exist");
	}
	
	public StaffNoExistenceException(String message) {
		super(message);
	}

}
