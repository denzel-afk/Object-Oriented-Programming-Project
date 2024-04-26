package exception;
/**
 * A custom exception class for handling errors related to staff promotion.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2021-04-26
 */
public class PromotionException extends Exception {
    public PromotionException() {
        super("Unable to promote staff");
    }

    public PromotionException(String message) {
        super(message);
    }
}
