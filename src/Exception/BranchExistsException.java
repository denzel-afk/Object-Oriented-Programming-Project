package exception;

public class BranchExistsException extends Exception {
    public BranchExistsException() {
        super("Branch's name already existed");
    }

    public BranchExistsException(String message) {
        super(message);
    }
}
