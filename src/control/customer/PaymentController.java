package control.customer;

/**
 * PaymentController is an abstract class that is used to control the payment.
 * This class is used to process the payment.
 * 
 * @version 1.0
 * @since 2024-04-26
 */

public abstract class PaymentController {
    /**
     * This method is used to process the payment.
     * 
     * @param total   The total price of the order.
     * @param payment The payment made by the customer.
     * @return boolean The boolean value to check if the payment is successful.
     */
    public abstract boolean processPayment(double total, double payment);
}
