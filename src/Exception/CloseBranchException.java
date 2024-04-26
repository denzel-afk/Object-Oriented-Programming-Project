package exception;

public class CloseBranchException extends Exception{
	public CloseBranchException() {
		super("Staff exists. Can not close branch");
	}
	
	public CloseBranchException(String message) {
		super(message);
	}

}