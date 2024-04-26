package control.customer;

import entity.Company;
import java.util.Scanner;

public class CashController extends PaymentController {
    public boolean processPayment(double total, double payment) {
        return payment >= total;
    }

    public boolean cash(double total) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Total: %.2f%n", total);
        System.out.printf("Enter amount to pay: %.2f% - ", total);
        double payment = sc.nextDouble();
        if (processPayment(total, payment)) {
            System.out.printf("Paid: %.2f%n", payment);
            System.out.printf("Change: %.2f%n", payment - total);
            System.out.println("Payment successful! Thank you for your purchase!");
            return true;
        } else {
            System.out.println("Insufficient funds, exiting!");
            return false;
        }
    }
}
