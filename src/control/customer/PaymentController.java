package control.customer;

public abstract class PaymentController {
    public abstract boolean processPayment(double total, double payment);
}
