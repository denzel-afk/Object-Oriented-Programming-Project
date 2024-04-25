package Exception;

public class AddStaffException extends Exception {
    public AddStaffException() {
        super("Staff can not be added");
    }

    public AddStaffException(String message) {
        super(message);
    }
}
