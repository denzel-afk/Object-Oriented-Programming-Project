package boundary;

import java.util.Scanner;

import control.MenuEditController;
import control.MenuViewController;
import control.StaffViewController;
import entity.Role;
import entity.Staff;
import entity.User;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.PromotionException;
import exception.StaffExistException;
import exception.WrongPasswordException;

import java.util.ArrayList;

/**
 * ManagerMainPage class is used to display the main page for the manager to
 * interact with the system. The manager can view all orders, view an order,
 * process an order, display staff list, display menu, add menu item, edit menu
 * item, delete menu item, change password, and log out.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class ManagerMainPage extends StaffMainPage {

  static Scanner sc = new Scanner(System.in);

  /**
   * The ManagerUI method is used to display the main page for the manager to
   * interact with the system. The manager can view all orders, view an order,
   * process an order, display staff list, display menu, add menu item, edit menu
   * item, delete menu item, change password, and log out.
   * 
   * @param user The user that is currently logged in.
   */
  public static void ManagerUI(User user) {

    System.out.println("-----Manager-----");

    Staff staff = null;
    if (user instanceof Staff)
      staff = (Staff) user;

    String branchName = staff.getBranchName();
    String orderID, name;
    double price;
    int choice, index, category;

    do {
      System.out.println("What action do you want to do:");
      System.out.println("1)View All Orders\n"
          + "2)View Order\n"
          + "3)Process Order\n"
          + "4)Display Staff List\n"
          + "5)Display Menu\n"
          + "6)Add Menu Item\n"
          + "7)Edit Menu Item\n"
          + "8)Delete Menu Item\n"
          + "9)Change Password\n"
          + "10)Log Out");
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          viewNewOrders(branchName); // call static method from StaffMainPage
          break;
        case 2:
          System.out.print("Please input the order ID:");
          orderID = sc.next();
          viewAnOrder(branchName, orderID); // call static method from StaffMainPage
          break;

        case 3:
          System.out.print("Please input the order ID:");
          orderID = sc.next();
          updateOrderStatus(branchName, orderID); // call static method from StaffMainPage
          break;

        case 4: // Display Staff List
          StaffViewController.displayStaffList(branchName);
          break;

        case 5: // Display Menu
          MenuViewController.displayMenu(branchName);
          break;

        case 6: // Add Menu Item
          sc.nextLine();
          System.out.print("Enter item name:");
          name = sc.nextLine();

          System.out.print("Enter item price:");
          price = sc.nextDouble();
          // sc.nextLine();

          System.out.println("Enter item category\n1)SET_MEAL\n2)BURGER\n3)SIDE\n4)DRINK:");
          category = sc.nextInt();

          MenuEditController.addMenuItem(branchName, name, price, category);
          break;

        case 7: // Edit Menu Item
          MenuViewController.displayMenu(branchName);
          System.out.print("Enter index of item to edit:");
          index = sc.nextInt();
          int col;
          do {
            System.out.println("Enter column to edit 1) Name\n2) Price\n3) Category");
            col = sc.nextInt();
          } while (col < 1 || col > 3);

          switch (col) {
            case 1:
              System.out.print("Enter new name:");
              name = sc.next();
              MenuEditController.editMenuItemName(branchName, index, name);
              break;
            case 2:
              System.out.println("Enter new price:");
              price = sc.nextDouble();
              MenuEditController.editMenuItemPrice(branchName, index, price);
              break;
            case 3:
              System.out.println("Enter item category\n1)SET_MEAL\n2)BURGER\n3)SIDE\n4)DRINK:");
              category = sc.nextInt();
              MenuEditController.editMenuItemCategory(branchName, index, category);
              break;
          }
          break;

        case 8: // Delete Menu Item
          MenuViewController.displayMenu(branchName);
          System.out.print("Enter index of item to delete:");
          index = sc.nextInt();
          MenuEditController.removeMenuItem(branchName, index);
          break;

        case 9: // Change Password
          UserChangePassword.changePasswordUI(staff);
          break;

        case 10: // Log out
          LogOut.logoutUI(staff, Role.MANAGER);
          break;
      }
    } while (choice >= 1 && choice <= 10);
  }
}