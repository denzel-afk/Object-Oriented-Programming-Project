package boundary;

import java.util.Scanner;

import entity.Admin;
import entity.Company;
import entity.Staff;
import entity.User;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.PromotionException;
import exception.StaffExistException;
import exception.WrongPasswordException;
import control.AccountController;
import control.PasswordController;

/**
 * UserChangePassword class is used to display the change password page for the
 * user to interact with the system. The user can change their password.
 * The user can also choose to return to the previous page.
 * The user can also choose to exit the system.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class UserChangePassword {

	static Scanner sc = new Scanner(System.in);

	/**
	 * The changePasswordUI method is used to display the change password page for
	 * the user to interact with the system. The user can change their password.
	 * The user can also choose to return to the previous page.
	 * The user can also choose to exit the system.
	 * 
	 * @param user The user that is currently logged in.
	 */
	@SuppressWarnings("incomplete-switch")
	public static void changePasswordUI(User user) {

		System.out.println("Enter your old password");
		String oldPassword = sc.next();

		System.out.println("Enter your new password");
		String newPassword = sc.next();

		try {
			PasswordController.changePassword(user, oldPassword, newPassword);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Returning to previous page...");
			return;
		}

		if (user instanceof Admin)
			AdminMainPage.AdminUI(user);

		if (user instanceof Staff) {
			Staff staffUser = (Staff) user;

			switch (staffUser.getRole()) { // need to add getRole in StaffController class?
				case STAFF:
					StaffMainPage.StaffUI(staffUser);
					break;
				case MANAGER:
					ManagerMainPage.ManagerUI(staffUser);
			}
		}

	}

}