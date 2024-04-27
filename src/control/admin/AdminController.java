package control.admin;

import java.util.Map;
import java.util.ArrayList;

import control.ExcelReaderWriter;
import entity.Staff;
import entity.Role;
import entity.Branch;
import entity.Company;
import entity.MenuCategory;
import entity.MenuItem;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.CloseBranchException;
import exception.PromotionException;
import exception.StaffExistException;

/**
 * AdminController class is used to control the admin functions
 * It provides methods for managing staff, branches, and payment methods
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class AdminController {

    /**
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void displayStaffByBranch() {
        ManpowerController.displayStaffByBranch();
    }

    /**
     * The displayStaffByRole method is used to display the staff by role
     */
    public static void displayStaffByRole() {
        ManpowerController.displayStaffByRole();
    }

    /**
     * The displayStaffByGender method is used to display the staff by gender
     */
    public static void displayStaffByGender() {
        ManpowerController.displayStaffByGender();
    }

    /**
     * The displayStaffByAge method is used to display the staff by age
     */
    public static void displayStaffByAge() {
        ManpowerController.displayStaffByAge();
    }

    /**
     * Transfers a staff member to another branch.
     * 
     * @param staff     The staff object to be transferred.
     * @param branchKey The key of the branch to which the staff is to be
     *                  transferred.
     * @throws StaffExistException If the staff already exists.
     * @throws AddStaffException   If an error occurs while adding staff.
     */
    public static void transferStaff(Staff staff, String branchKey) throws StaffExistException, AddStaffException {
        Staff tempStaff = new Staff(staff.getUserName(), staff.getUserId(), staff.getRole(),
                branchKey, staff.getAge(), staff.getGender());
        tempStaff.setPassword(staff.getPassword());

        Branch branch = Company.getBranch().get(branchKey);

        deleteStaff(staff);
        addStaff(tempStaff, branch);
    }

    /**
     * Assigns a staff member to a specific role and branch.
     * 
     * @param staff  The staff object to be assigned.
     * @param role   The role object to which the staff is to be assigned.
     * @param branch The branch object to which the staff is to be assigned.
     * @throws StaffExistException If the staff already exists.
     * @throws AddStaffException   If an error occurs while adding staff.
     */
    public static void assignStaff(Staff staff, Role role, Branch branch)
            throws StaffExistException, AddStaffException {

        staff.setRole(role);
        staff.setBranchName(branch.getBranchName());
        addStaff(staff, branch);
    }

    /**
     * Adds a staff member to the specified branch.
     * 
     * @param staff  The staff object to be added.
     * @param branch The branch object to which the staff is to be added.
     * @throws StaffExistException If the staff already exists.
     * @throws AddStaffException   If an error occurs while adding staff.
     */
    public static void addStaff(Staff staff, Branch branch) throws StaffExistException, AddStaffException {
        ManpowerController.addStaff(staff, branch);
    }

    /**
     * Deletes a staff member.
     * 
     * @param staff The staff object to be deleted.
     */
    public static void deleteStaff(Staff staff) {
        ManpowerController.deleteStaff(staff);
    }

    /**
     * Edits the username of a staff member.
     * 
     * @param staff The staff object whose username is to be edited.
     * @param name  The new username of the staff.
     * @throws BranchNotExistException If the branch does not exist.
     * @throws StaffExistException     If the staff already exists.
     * @throws AddStaffException       If the staff cannot be added.
     */
    public static void editStaffName(Staff staff, String name)
            throws BranchNotExistException, StaffExistException, AddStaffException {
        Staff temStaff = staff;
        Branch temBranch = getBranch(staff.getBranchName());
        temStaff.setUserName(name);
        deleteStaff(staff);
        addStaff(temStaff, temBranch);
    }

    /**
     * Edits the ID of a staff member.
     * 
     * @param staff The staff object whose ID is to be edited.
     * @param Id    The new ID of the staff.
     * @throws BranchNotExistException If the branch does not exist.
     * @throws StaffExistException     If the staff already exists.
     * @throws AddStaffException       If the staff cannot be added.
     */
    public static void editStaffId(Staff staff, String Id)
            throws BranchNotExistException, StaffExistException, AddStaffException {
        Staff temStaff = staff;
        Branch temBranch = getBranch(staff.getBranchName());
        temStaff.setUserId(Id);
        deleteStaff(staff);
        addStaff(temStaff, temBranch);
    }

    /**
     * The displayStaffByBranch method is used to display the staff by branch
     * 
     * @param staff The staff object
     * @param role  The new role of the staff
     * @throws BranchNotExistException If the branch does not exist
     * @throws StaffExistException     If the staff already exists
     * @throws AddStaffException       If the staff cannot be added
     */
    public static void editStaffRole(Staff staff, Role role)
            throws BranchNotExistException, StaffExistException, AddStaffException {
        Staff temStaff = staff;
        Branch temBranch = getBranch(staff.getBranchName());
        temStaff.setRole(role);
        deleteStaff(staff);
        addStaff(temStaff, temBranch);
    }

    /**
     * Edits the branch of a staff member.
     * 
     * @param staff  The staff object whose branch is to be edited.
     * @param branch The new branch of the staff.
     * @throws StaffExistException If the staff already exists.
     * @throws AddStaffException   If the staff cannot be added.
     */
    public static void editStaffBranch(Staff staff, Branch branch) throws StaffExistException, AddStaffException {
        deleteStaff(staff);
        addStaff(staff, branch);
    }

    /**
     * Promotes a staff member to a higher role.
     * 
     * @param staff The staff object to be promoted.
     * @throws PromotionException      If the staff cannot be promoted.
     * @throws BranchNotExistException If the branch does not exist.
     * @throws StaffExistException     If the staff already exists.
     * @throws AddStaffException       If the staff cannot be added.
     */
    public static void promoteStaff(Staff staff)
            throws PromotionException, BranchNotExistException, StaffExistException, AddStaffException {

        Branch branch = null;

        for (Map.Entry<String, Branch> e : Company.getBranch().entrySet()) {
            if (e.getKey().equals(staff.getBranchName())) {
                branch = e.getValue();
            }
        }

        if (staff.getRole().equals(Role.STAFF) && (branch.getNumManager() < (branch.getNumStaff() + 3) / 4)) {
            editStaffRole(staff, Role.MANAGER);
        } else if (staff.getRole().equals(Role.MANAGER)) {
            throw new PromotionException("Manager cannot be promoted");
        } else
            throw new PromotionException("Manager Quota Full");
    }

    /**
     * Opens a new branch.
     * 
     * @param branch The branch object representing the new branch to be opened.
     * @throws BranchExistsException If the branch already exists.
     */
    public static void openBranch(Branch branch) throws BranchExistsException {
        BranchOperationController.openBranch(branch);
    }

    /**
     * Closes a branch.
     * 
     * @param branch The branch object representing the branch to be closed.
     * @throws CloseBranchException If the branch cannot be closed.
     */
    public static void closeBranch(Branch branch) throws CloseBranchException {
        BranchOperationController.closeBranch(branch);
    }

    /**
     * Retrieves the branch with the given name.
     * 
     * @param branchName The name of the branch to retrieve.
     * @return The branch object.
     * @throws BranchNotExistException If the branch does not exist.
     */
    public static Branch getBranch(String branchName) throws BranchNotExistException {
        Branch branch = null;
        boolean found = false;

        for (Map.Entry<String, Branch> e : Company.getBranch().entrySet()) {
            if (e.getKey().equals(branchName)) {
                branch = e.getValue();
                found = true;
                break;
            }
        }
        if (!found)
            throw new BranchNotExistException();
        return branch;
    }

    private static final String pathName = "data/payment_method.xlsx";

    /**
     * Adds a new payment method to the list.
     * 
     * @param method The payment method to be added.
     */
    public static void addPaymentMethod(String method) {
        try {
            ArrayList<Object[]> payment = ExcelReaderWriter.readFile(pathName, 1);
            Object[] toWrite = new Object[1];

            toWrite[0] = method;
            for (int i = 1; i < payment.size(); i++) {
                if (payment.get(i)[0].equals(method)) {
                    System.out.println("Payment method already exists");
                    return;
                }
            }
            payment.add(toWrite);

            ExcelReaderWriter.writeFile(payment, pathName, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes a payment method from the list.
     * 
     * @param method The payment method to be removed.
     */
    public static void removePaymentMethod(String method) {
        try {
            ArrayList<Object[]> payment = ExcelReaderWriter.readFile(pathName, 1);

            for (int i = 0; i < payment.size(); i++) {
                if (payment.get(i)[0].equals(method)) {
                    payment.remove(i);
                    break;
                }
            }
            ExcelReaderWriter.writeFile(payment, pathName, 1);
            System.out.println("Payment method removed: " + method);
        } catch (Exception e) {
            System.out.println("Error removing payment method: " + e.getMessage());
        }
    }

    /**
     * Displays all available payment methods.
     */
    public static void displayPaymentMethods() {
        try {
            ArrayList<Object[]> payment = ExcelReaderWriter.readFile(pathName, 1);

            System.out.println("Payment Methods:");
            for (int i = 1; i < payment.size(); i++) {
                System.out.println((i) + ". " + payment.get(i)[0]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Payment method displayed");
    }
}
