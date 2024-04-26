package control;

import exception.WrongPasswordException;
import entity.User;

//this class is controlling all of things related to password change
public class PasswordController {

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