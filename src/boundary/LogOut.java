package boundary;

import java.util.*;

import entity.Admin;
import entity.Company;
import entity.Role;
import entity.Staff;
import entity.User;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.PromotionException;
import exception.StaffExistException;
import exception.WrongPasswordException;

/**
 * LogOut class provides functionality for logging out users from the system.
 * It displays the logout page for the employee to interact with the system and
 * choose to log out.
 * The employee can log out as a staff or an admin.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class LogOut {

	static Scanner sc = new Scanner(System.in);

	/**
	 * Displays the logout page for the employee to interact with the system and
	 * choose to log out.
	 * 
	 * @param user The user that is currently logged in.
	 * @param role The role of the user that is currently logged in.
	 */
	public static void logoutUI(User user, Role role) {

		System.out.println("Are you sure you want to log out?");
		System.out.println("1: No, return to my staff page.");
		System.out.println("2: Yes, log out.");

		int choice = sc.nextInt();

		if (choice == 1) {
			if (role.equals(Role.STAFF)) {
				StaffMainPage.StaffUI(user);
			}
			if (role.equals(Role.MANAGER)) {
				ManagerMainPage.ManagerUI(user);
			}
			if (role.equals(Role.ADMIN)) {
				AdminMainPage.AdminUI(user);
			}

		} else if (choice == 2) {
			MainUI.MainPageUI();
		}
	}
}