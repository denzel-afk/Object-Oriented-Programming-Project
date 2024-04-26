package boundary;

import java.util.*;

import entity.Company;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.PromotionException;
import exception.StaffExistException;
import exception.WrongPasswordException;

/**
 * MainUI class is used to display the main page for the user to interact with
 * the system.
 * The user can choose to login as a customer or a staff.
 * The user can also choose to exit the system.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class MainUI {

	static Scanner sc = new Scanner(System.in);

	/**
	 * The MainPageUI method is used to display the main page for the user to
	 * interact with the system.
	 * The user can choose to login as a customer or a staff.
	 * The user can also choose to exit the system.
	 */
	public static void MainPageUI() {

		System.out.println("Welcome to 20-02 Fast Food Chain.");

		int choice;

		do {
			choice = roleChoice();

			switch (choice) {
				case 1:
					CustomerMainPage.CustomerMainPageUI();
					break;
				case 2:
					EmployeeLogin.employeeLoginUI();
					break;
				case 3:
					System.out.println("Bye!");
					break;
				default:
					System.out.println("Try again");
					break;
			}
		} while (choice != 3);
	}

	/**
	 * The roleChoice method is used to prompt the user to choose their role.
	 * The user can choose to login as a customer or a staff.
	 * 
	 * @return choice The choice of the user for the role, either STAFF, MANAGER, or
	 *         ADMIN.
	 */
	public static int roleChoice() {

		System.out.println("Enter your role");
		System.out.println("1: Customer\n2: Staff");
		int choice = sc.nextInt();

		return choice;
	}
}