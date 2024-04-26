package control.customer;

import java.util.Scanner;

import entity.Company;

/*
 * CreditCardController class is used to control the credit card payment
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian 
 * @version 1.0
 * @since 2024-04-26
 */

public class CreditCardController extends PaymentController {
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
     * @param cardNo the card number of the customer
     */
    private String cardNo;

    /**
     * The CreditCardController constructor is used to create a new credit card
     * controller.
     * 
     * @param cardNo The card number of the customer.
     */
    public CreditCardController(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * The card method is used to pay by card.
     * 
     * @param total The total amount to be paid.
     * @return true if the payment is successful, false otherwise.
     */
    public boolean Card(double total) {

        Scanner sc = new Scanner(System.in);
        double payment = 0;

        System.out.print("Press C to pay: ");
        char select = sc.next().charAt(0);

        if (select == 'C') {
            payment = total;
        }

        /*
         * @param payment the amount paid by the customer
         */
        if (processPayment(total, payment)) {
            System.out.printf("Paid: %.2f\n", total);
            System.out.printf("Card No: %s\n", cardNo);
            System.out.println("Payment successful! Thank you for your purchase!");
            return true;
        } else {
            System.out.println("Payment not successful, exiting");
            return false;
        }
    }
}