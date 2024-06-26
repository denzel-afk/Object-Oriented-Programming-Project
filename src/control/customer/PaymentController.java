package control.customer;

/**
 * PaymentController is an abstract class that is used to control the payment.
 * This class is used to process the payment.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public abstract class PaymentController {
    /**
     * Processes the payment for an order.
     * 
     * @param total   The total price of the order.
     * @param payment The payment made by the customer.
     * @return True if the payment is successfully processed; false otherwise.
     */
    public abstract boolean processPayment(double total, double payment);

}
