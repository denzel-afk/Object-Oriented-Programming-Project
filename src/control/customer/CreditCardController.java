package control.customer;

import java.util.Scanner;

import entity.Company;

public class CreditCardController extends PaymentController {
    public boolean processPayment(double total, double payment) {
        return payment >= total;
    }

    private String cardNo;

    public CreditCardController(String cardNo) {
        this.cardNo = cardNo;
    }

    public boolean Card(double total) {

        Scanner sc = new Scanner(System.in);
        double payment = 0;

        System.out.print("Press C to pay: ");
        char select = sc.next().charAt(0);

        if (select == 'C') {
            payment = total;
        }

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