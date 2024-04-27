package exception;

/**
 * A custom exception class for handling errors related to staff promotion.
 * This exception is thrown when there is an issue with promoting staff members.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class PromotionException extends Exception {
    /**
     * Constructs a new PromotionException with the default message "Unable to
     * promote staff".
     */
    public PromotionException() {
        super("Unable to promote staff");
    }

    /**
     * Constructs a new PromotionException with the specified detail message.
     * 
     * @param message The detail message (which is saved for later retrieval by the
     *                getMessage() method).
     */
    public PromotionException(String message) {
        super(message);
    }
}