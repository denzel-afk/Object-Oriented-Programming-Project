package boundary;

import java.util.Scanner;
import java.util.ArrayList;
import entity.*;
import control.*;
import control.admin.AdminController;
import control.customer.CashController;
import control.customer.CreditCardController;
import control.customer.CustomerViewInterface;
import control.customer.OrderCheckOutInterface;
import control.customer.OrderCollectionInterface;
import control.customer.OrderCreationController;
import control.customer.PayNowController;

/**
 * CustomerMainPage class is used to display the main page for the customer to
 * interact with the system. The customer can view their order status, collect
 * their order, and create a new order.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class CustomerMainPage {

  static Scanner sc = new Scanner(System.in);

  /**
   * @param branchName the name of the branch
   * @param orderID    the order ID
   */
  private static String branchName, orderID;

  /**
   * This method is used to display the main page for the customer to interact
   * with the system. The customer can view their order status, collect their
   * order, and create a new order.
   */
  public static void CustomerMainPageUI() {

    System.out.println("Welcome Customer!\nPlease enter Branch by their name:\n");
    // Display branch names
    CompanyController.displayBranch();
    branchName = sc.next();
    int choice;

    do {
      System.out.println("What would you like to do?");
      System.out.println("1: Check placed order with your Order ID");
      System.out.println("2: Collect your order");
      System.out.println("3: Create a new order");
      System.out.println("Press any number to return to main page");

      choice = sc.nextInt();

      switch (choice) {
        case (1):
          viewOrderStatus(branchName);
          break;
        case (2):
          collectOrder(branchName);
          break;
        case (3):
          newOrderProcess(branchName);
          break;
      }
    } while (choice >= 1 && choice <= 3);

  }

  /**
   * This method is used to create a new order
   * 
   * @param branchName The name of the branch
   */
  public static void newOrderProcess(String branchName) {
    CustomerViewInterface viewer = new OrderViewController();
    OrderCheckOutInterface checkout = new OrderStatusController();
    int takeaway, choice, qty, index;
    String remarks, text;

    do {
      System.out.println("Select:\n 1) Dine-In\n 2) Takeaway");
      takeaway = sc.nextInt();
    } while (takeaway < 1 || takeaway > 2);

    orderID = OrderCreationController.createOrder(branchName, ((takeaway == 1) ? false : true));

    do {
      System.out.println("What would you like to do?");
      System.out.println("1: Add a menu item to your cart");
      System.out.println("2: Edit a menu item in your cart");
      System.out.println("3: Delete a menu item from your cart");
      System.out.println("4: View order cart");
      System.out.println("5: Check out your cart for payment");

      choice = sc.nextInt();

      switch (choice) {
        case (1): // add a menu item to my cart
          MenuViewController.displayMenu(branchName);

          System.out.println("Select item to add to order: ");
          index = sc.nextInt();
          System.out.println("Enter quantity?: ");
          qty = sc.nextInt();
          sc.nextLine();

          System.out.println("Any remarks?: ");
          remarks = sc.nextLine();

          OrderCreationController.addToOrder(branchName, orderID, index, qty, remarks);
          break;

        case (2): // edit an Order
          viewer.viewOrderDetails(branchName, orderID);

          System.out.println("Which item do you want to edit?:");
          index = sc.nextInt();
          System.out.println("Edit quantity:");
          qty = sc.nextInt();
          sc.nextLine();

          System.out.println("Edit remarks:");
          remarks = sc.nextLine();
          OrderCreationController.editOrder(branchName, orderID, index, qty, remarks);
          break;

        case (3): // delete an order
          viewer.viewOrderDetails(branchName, orderID);

          System.out.println("Which item do you want to remove?:");
          index = sc.nextInt();
          OrderCreationController.deleteFromOrder(branchName, orderID, index);
          break;

        case (4):
          viewer.viewOrderDetails(branchName, orderID);
          break;
        case (5): // checkout from the cart
          double total = viewer.viewOrderDetails(branchName, orderID);
          if (total <= 0)
            break;
          String pathName = "data/payment_method.xlsx";
          boolean payment = false;
          System.out.println("Choose payment method: (Please type the String e.g. Cash, PayNow)");
          AdminController.displayPaymentMethods();
          String paymentMethod = sc.next();
          ArrayList<Object[]> payments = ExcelReaderWriter.readFile(pathName, 1);
          for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i)[0].equals(paymentMethod)) {
              payment = true;
              break;
            }
          }
          checkout.checkOut(branchName, orderID, payment);
          choice = 6;
          break;
      }
    } while (choice >= 1 && choice <= 5);
  }

  /**
   * This method is used to view the order status
   * 
   * @param branchName The name of the branch
   */
  public static void viewOrderStatus(String branchName) {
    CustomerViewInterface viewer = new OrderViewController();
    System.out.println("Please input your OrderID to view your Order's status:  ");
    String orderID = sc.next();

    viewer.viewOrderStatus(branchName, orderID);
  }

  /**
   * This method is used to collect the order
   * 
   * @param branchName The name of the branch
   */
  public static void collectOrder(String branchName) {
    OrderCollectionInterface collect = new OrderStatusController();
    System.out.println("Please input your OrderID to collect your order:  ");
    String orderID = sc.next();

    collect.collectOrder(branchName, orderID);
  }
}