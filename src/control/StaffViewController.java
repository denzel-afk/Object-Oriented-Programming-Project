package control;

import java.util.ArrayList;

import entity.Staff;
import entity.Company;
import entity.Branch;

/*
 * StaffViewController class is used to control the staff view functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

//this class is used to dispaly the staff of a branch
public class StaffViewController {

    /**
     * This method is used to display the staff list.
     * 
     * @param branchName The branch name.
     */
    public static void displayStaffList(String branchName) {
        /*
         * @param branchName The branch name.
         */
        Branch branch = Company.getBranch().get(branchName);
        ArrayList<Staff> staffList = branch.getStaffList();

        System.out.println("Staff List:");
        System.out.printf("%-15s\t%s\t%-10s\t%s\n", "Name", "Age", "Gender", "Role");

        /*
         * Display the staff list
         */
        for (Staff staff : staffList) {
            System.out.printf("%-15s\t%d\t%-10s\t%s\n", staff.getUserName(), staff.getAge(), staff.getGender(),
                    staff.getRole());
        }
    }
}
