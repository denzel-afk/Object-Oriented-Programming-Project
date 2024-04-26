package control;

import entity.Branch;
import entity.Company;
import entity.User;
import exception.StaffNoExistenceException;
import exception.WrongPasswordException;

/**
 * AccountController class is used to control the account functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class AccountController {

    /**
     * The checkExisting method is used to check if the user exists.
     * 
     * @param loginID The login ID of the user.
     * @return The user.
     * @throws StaffNoExistenceException If the user does not exist.
     */
    public static User checkExisting(String loginID) throws StaffNoExistenceException {

        for (User user : Company.getAdmin()) {
            if (user.getUserId().equals(loginID)) {
                return user;
            }
        }

        for (Branch branch : Company.getBranch().values()) {
            for (User user : branch.getStaffList()) {
                if (user.getUserId().equals(loginID)) {
                    return user;
                }
            }
        }

        // if user not found
        throw new StaffNoExistenceException();
    }

    /**
     * The checkValid method is used to check if the password is valid.
     * 
     * @param user     The user.
     * @param password The password.
     * @return true if the password is valid, false otherwise.
     * @throws WrongPasswordException If the password is wrong.
     */
    public static boolean checkValid(User user, String password) throws WrongPasswordException {
        if (user.getPassword().equals(password))
            return true;

        throw new WrongPasswordException();
    }

}