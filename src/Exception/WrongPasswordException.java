package exception;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Your new password is the same as the old password/invalid. Please enter a different password.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
