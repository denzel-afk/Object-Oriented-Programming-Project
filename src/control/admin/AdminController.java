package control.admin;

import java.util.Map;

import entity.Staff;
import entity.Role;
import entity.Branch;
import entity.Company;
import exception.AddStaffException;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.CloseBranchException;
import exception.PromotionException;
import exception.StaffExistException;

/*
 * AdminController class is used to control the admin functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class AdminController {

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void displayStaffByBranch() {
        ManpowerController.displayStaffByBranch();
    }

    /*
     * The displayStaffByRole method is used to display the staff by role
     */
    public static void displayStaffByRole() {
        ManpowerController.displayStaffByRole();
    }

    /*
     * The displayStaffByGender method is used to display the staff
     */
    public static void displayStaffByGender() {
        ManpowerController.displayStaffByGender();
    }

    /*
     * The displayStaffByAge method is used to display the staff by age
     */
    public static void displayStaffByAge() {
        ManpowerController.displayStaffByAge();
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void transferStaff(Staff staff, String branchKey) throws StaffExistException, AddStaffException {

        /*
         * The tempStaff object is used to store the staff object that is returned from
         * the checkValid method.
         */
        Staff tempStaff = new Staff(staff.getUserName(), staff.getUserId(), staff.getRole(),
                branchKey, staff.getAge(), staff.getGender());
        tempStaff.setPassword(staff.getPassword());

        /*
         * The branch object is used to store the branch object that is returned from
         * the getBranch method.
         */
        Branch branch = Company.getBranch().get(branchKey);

        deleteStaff(staff);
        addStaff(tempStaff, branch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void assignStaff(Staff staff, Role role, Branch branch)
            throws StaffExistException, AddStaffException {

        staff.setRole(role);
        staff.setBranchName(branch.getBranchName());
        addStaff(staff, branch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void addStaff(Staff staff, Branch branch) throws StaffExistException, AddStaffException {
        ManpowerController.addStaff(staff, branch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void deleteStaff(Staff staff) {
        ManpowerController.deleteStaff(staff);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void editStaffName(Staff staff, String name)
            throws BranchNotExistException, StaffExistException, AddStaffException {
        Staff temStaff = staff;
        Branch temBranch = getBranch(staff.getBranchName());
        temStaff.setUserName(name);
        deleteStaff(staff);
        addStaff(temStaff, temBranch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void editStaffId(Staff staff, String Id)
            throws BranchNotExistException, StaffExistException, AddStaffException {
        Staff temStaff = staff;
        Branch temBranch = getBranch(staff.getBranchName());
        temStaff.setUserId(Id);
        deleteStaff(staff);
        addStaff(temStaff, temBranch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void editStaffRole(Staff staff, Role role)
            throws BranchNotExistException, StaffExistException, AddStaffException {
        Staff temStaff = staff;
        Branch temBranch = getBranch(staff.getBranchName());
        temStaff.setRole(role);
        deleteStaff(staff);
        addStaff(temStaff, temBranch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void editStaffBranch(Staff staff, Branch branch) throws StaffExistException, AddStaffException {
        deleteStaff(staff);
        addStaff(staff, branch);

    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
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

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void openBranch(Branch branch) throws BranchExistsException {
        BranchOperationController.openBranch(branch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void closeBranch(Branch branch) throws CloseBranchException {
        BranchOperationController.closeBranch(branch);
    }

    /*
     * The displayStaffByBranch method is used to display the staff by branch
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

}