package control.customer;

import java.util.Scanner;

import entity.Company;

public class PayNowController extends PaymentController {
    private String phonenumber;

    public boolean processPayment(double total, double payment) {
        return payment >= total;
    }

    public PayNowController(String phonenumber) {
        this.phonenumber = phonenumber;
    }

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
