package boundary;

import java.util.Scanner;
import control.*;
import control.customer.CustomerViewInterface;
import entity.*;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.PromotionException;
import exception.StaffExistException;
import exception.WrongPasswordException;

/*
 * StaffMainPage class is used to display the main page for the staff to
 * interact with the system. The staff can view new orders, view an order,
 * update order status, change password, and log out.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class StaffMainPage {

  static Scanner sc = new Scanner(System.in);

  /*
   * The StaffUI method is used to display the main page for the staff to
   * interact with the system. The staff can view new orders, view an order,
   * update order status, change password, and log out.
   */
  public static void StaffUI(User user) {

    System.out.println("-----Staff-----");

    /*
     * The staffUser object is used to store the staff object that is returned from
     * the
     * checkValid method.
     */
    Staff staffUser = null;
    if (user instanceof Staff)
      staffUser = (Staff) user;

    /*
     * @param branchName The branch name of the staff.
     * 
     * @param orderID The order ID.
     * 
     * @param choice The choice of the user.
     */
    String branchName = staffUser.getBranchName();
    String orderID;
    int choice;

    do {
      System.out.println("What action do you want to do:");
      System.out.println("1)View New Orders\n"
          + "2)View an Order\n"
          + "3)Update Order Status\n"
          + "4)Change Password\n"
          + "5)Log Out");

      choice = sc.nextInt();

      /*
       * @param choice The choice of the user.
       */
      switch (choice) {
        case 1:
          viewNewOrders(branchName);
          break;
        case 2:
          System.out.println("Please input the order ID:");
          orderID = sc.next();
          viewAnOrder(branchName, orderID);
          break;
        case 3:
          System.out.println("Please input the order ID:");
          orderID = sc.next();
          updateOrderStatus(branchName, orderID);
          break;
        case 4:
          // Change Password
          UserChangePassword.changePasswordUI(staffUser);
          break;
        case 5:
          // Log out
          LogOut.logoutUI(staffUser, Role.STAFF);
          break;
      }

    } while (choice > 0 && choice <= 5);
  }

  /*
   * This method is used to view new orders
   */
  public static void viewNewOrders(String branchName) {
    /*
     * @param viewer The viewer interface
     * 
     * @param branchName The name of the branch
     */
    StaffViewInterface viewer = new OrderViewController();
    viewer.viewNewOrders(branchName);
  }

  /*
   * This method is used to view an order
   */
  // Case 2
  public static void viewAnOrder(String branchName, String orderID) {
    /*
     * @param viewer The viewer interface
     * 
     * @param branchName The name of the branch
     * 
     * @param orderID The order ID
     */
    CustomerViewInterface viewer = new OrderViewController();
    viewer.viewOrderDetails(branchName, orderID);
  }

  /*
   * This method is used to update order status
   */
  // Case 3
  public static void updateOrderStatus(String branchName, String orderID) {
    /*
     * @param process The process interface
     * 
     * @param branchName The name of the branch
     * 
     * @param orderID The order ID
     */
    OrderProcessingInterface process = new OrderStatusController();
    process.processOrder(branchName, orderID);
  }
}