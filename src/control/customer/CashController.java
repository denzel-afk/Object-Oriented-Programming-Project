package control.customer;

import entity.Company;
import java.util.Scanner;

/**
 * CashController class is used to control the cash payment
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class CashController extends PaymentController {

    /**
     * The processPayment method is used to process the payment.
     * 
     * @param total   The total amount to be paid.
     * @param payment The amount paid by the customer.
     * @return true if the payment is successful, false otherwise.
     */
    public boolean processPayment(double total, double payment) {
        return payment >= total;
    }

    /**
     * The cash method is used to pay by cash.
     * 
     * @param total The total amount to be paid.
     * @return true if the payment is successful, false otherwise.
     */
    public boolean cash(double total) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Total: $%.2f%n", total);
        System.out.printf("Enter amount to pay: $%.2f - ", total); // Removed the % character after $

        double payment = sc.nextDouble();
        if (processPayment(total, payment)) {
            System.out.printf("Paid: $%.2f%n", payment);
            System.out.printf("Change: $%.2f%n", payment - total);
            System.out.println("Payment successful! Thank you for your purchase!");
            return true;
        } else {
            System.out.println("Insufficient funds, exiting!");
            return false;
        }
    }
}
