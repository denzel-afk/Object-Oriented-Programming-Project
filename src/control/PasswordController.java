package control;

import exception.WrongPasswordException;
import entity.User;

/*
 * PasswordController class is used to control the password functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

//this class is controlling all of things related to password change
public class PasswordController {

    /**
     * The changePassword method is used to change the password.
     * 
     * @param user        The user.
     * @param oldPassword The old password.
     * @param newPassword The new password.
     * @return true if the password is changed, false otherwise.
     * @throws WrongPasswordException If the password is wrong.
     */
    public static boolean changePassword(User user, String oldPassword, String newPassword)
            throws WrongPasswordException {
        if (AccountController.checkValid(user, oldPassword)) {
            user.setPassword(newPassword);
            return true;
        } else {
            throw new WrongPasswordException();
        }
    }
}