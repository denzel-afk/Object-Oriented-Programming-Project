package control.customer;

import java.util.Scanner;

import entity.Company;

/**
 * PayNowController class is used to control the PayNow payment
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class PayNowController extends PaymentController {
    /**
     * @param phonenumber the phone number of the customer
     */
    private String phonenumber;

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
     * The PayNowController constructor is used to create a new PayNow controller.
     * 
     * @param phonenumber The phone number of the customer.
     */
    public PayNowController(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * The payNow method is used to pay by PayNow.
     * 
     * @param total The total amount to be paid.
     * @return true if the payment is successful, false otherwise.
     */
    public boolean payNow(double total) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter P to pay: ");
        char choice = sc.next().charAt(0);
        if (choice == 'P') {
            System.out.printf("Paid: %.2f\n", total);
            System.out.printf("Phone No: %s\n", phonenumber);
            System.out.println("Payment successful! Thank you for your purchase!");
            return true;
        } else {
            System.out.println("Payment not successful, exiting");
            return false;
        }
    }
}
