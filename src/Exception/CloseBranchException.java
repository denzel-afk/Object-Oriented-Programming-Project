package exception;

/**
 * A custom exception class for handling errors related to closing branch.
 * This exception will be shown when a branch has staffs and cannot be closed.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */

public class CloseBranchException extends Exception {
	/**
	 * Constructs a new CloseBranchException with a default message. This exception
	 * will be shown when a branch has staffs and cannot be closed.
	 */
	public CloseBranchException() {
		super("Staff exists. Can not close branch");
	}

	/**
	 * Constructs a new CloseBranchException with the specified detail message.
	 * 
	 * @param message the detail message (which is saved for later retrieval by the
	 *                getMessage() method)
	 */

	public CloseBranchException(String message) {
		super(message);
	}

}