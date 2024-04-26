package exception;

public class StaffNoExistenceException extends Exception{
	public StaffNoExistenceException() {
		super("Staff login ID does not exist");
	}
	
	public StaffNoExistenceException(String message) {
		super(message);
	}

}
