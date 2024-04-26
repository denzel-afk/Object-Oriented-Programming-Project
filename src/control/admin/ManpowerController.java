package control.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import entity.Staff;
import entity.User;
import exception.AddStaffException;
import exception.StaffExistException;
import entity.Role;
import entity.Admin;
import entity.Branch;
import entity.Company;
import control.ExcelReaderWriter;

/**
 * ManpowerController class is used to control the manpower functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class ManpowerController {

    /**
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void displayStaffByBranch() {
        System.out.println("Filtered by Branch");

        System.out.printf("%-10s", "BRANCH");
        System.out.printf("%-19s", "USERNAME");
        System.out.printf("%-13s", "LOGIN ID");
        System.out.printf("%-10s", "ROLE");
        System.out.printf("%-8s", "GENDER");
        System.out.printf("%-7s %n", "AGE");

        /*
         * The branch object is used to store the branch object that is returned from
         * the
         * getBranch method.
         */
        for (Branch branch : Company.getBranch().values()) {
            for (Staff staff : branch.getStaffList()) {
                System.out.printf("%-10s", staff.getBranchName());
                System.out.printf("%-19s", staff.getUserName());
                System.out.printf("%-13s", staff.getUserId());
                System.out.printf("%-10s", staff.getRole());
                System.out.printf("%-8s", staff.getGender());
                System.out.printf("%-7s %n", staff.getAge());
            }
            System.out.println("");
        }
    }

    /**
     * The displayStaffByRole method is used to display the staff by role
     */
    public static void displayStaffByRole() {
        System.out.println("Filtered by Role");

        System.out.printf("%-10s", "ROLE");
        System.out.printf("%-19s", "USERNAME");
        System.out.printf("%-13s", "LOGIN ID");
        System.out.printf("%-10s", "BRANCH");
        System.out.printf("%-8s", "GENDER");
        System.out.printf("%-7s %n", "AGE");

        /*
         * The admin object is used to store the admin object that is returned from the
         * getAdmin method.
         */
        for (Admin admin : Company.getAdmin()) {
            System.out.printf("%-10s", admin.getRole());
            System.out.printf("%-19s", admin.getUserName());
            System.out.printf("%-13s", admin.getUserId());
            System.out.printf("%-10s", "Company");
            System.out.printf("%-8s", admin.getGender());
            System.out.printf("%-7s %n", admin.getAge());
        }

        System.out.println("");
        /*
         * The branch object is used to store the branch object that is returned from
         * the
         * getBranch method.
         */
        for (Branch branch : Company.getBranch().values()) {
            /*
             * The staff object is used to store the staff object that is returned from the
             * getStaffList method.
             */
            for (Staff staff : branch.getStaffList()) {
                if (staff.getRole() == Role.STAFF) {
                    System.out.printf("%-10s", staff.getRole());
                    System.out.printf("%-19s", staff.getUserName());
                    System.out.printf("%-13s", staff.getUserId());
                    System.out.printf("%-10s", staff.getBranchName());
                    System.out.printf("%-8s", staff.getGender());
                    System.out.printf("%-7s %n", staff.getAge());
                }
            }
        }

        System.out.println("");
        /*
         * The branch object is used to store the branch object that is returned from
         * the
         * getBranch method.
         */
        for (Branch branch : Company.getBranch().values()) {
            /*
             * The staff object is used to store the staff object that is returned from the
             * getStaffList method.
             */
            for (Staff staff : branch.getStaffList()) {
                if (staff.getRole() == Role.MANAGER) {
                    System.out.printf("%-10s", staff.getRole());
                    System.out.printf("%-19s", staff.getUserName());
                    System.out.printf("%-13s", staff.getUserId());
                    System.out.printf("%-10s", staff.getBranchName());
                    System.out.printf("%-8s", staff.getGender());
                    System.out.printf("%-7s %n", staff.getAge());
                }
            }
        }

        System.out.println("");
    }

    /*
     * The displayStaffByGender method is used to display the staff
     */
    public static void displayStaffByGender() {

        String[] genderArray = { "M", "F" };

        System.out.println("Filtered by Gender");

        System.out.printf("%-8s", "GENDER");
        System.out.printf("%-19s", "USERNAME");
        System.out.printf("%-13s", "LOGIN ID");
        System.out.printf("%-10s", "BRANCH");
        System.out.printf("%-10s", "ROLE");
        System.out.printf("%-7s %n", "AGE");
        /*
         * The genderArray object is used to store the genderArray object that is
         * returned
         * from the getAdmin and getStaffList method.
         */
        for (String s : genderArray) {
            /*
             * The admin object is used to store the admin object that is returned from the
             * getAdmin method.
             */
            for (Admin admin : Company.getAdmin()) {
                if (admin.getGender().equals(s)) {
                    System.out.printf("%-8s", admin.getGender());
                    System.out.printf("%-19s", admin.getUserName());
                    System.out.printf("%-13s", admin.getUserId());
                    System.out.printf("%-10s", "Company");
                    System.out.printf("%-10s", admin.getRole());
                    System.out.printf("%-7s %n", admin.getAge());
                }
            }
            /*
             * The branch object is used to store the branch object that is returned from
             * the
             * getBranch method.
             */
            for (Branch branch : Company.getBranch().values()) {
                /*
                 * The staff object is used to store the staff object that is returned from the
                 * getStaffList method.
                 */
                for (Staff staff : branch.getStaffList()) {
                    if (staff.getGender().equals(s)) {
                        System.out.printf("%-8s", staff.getGender());
                        System.out.printf("%-19s", staff.getUserName());
                        System.out.printf("%-13s", staff.getUserId());
                        System.out.printf("%-10s", staff.getBranchName());
                        System.out.printf("%-10s", staff.getRole());
                        System.out.printf("%-7s %n", staff.getAge());
                    }
                }
            }
            System.out.println("");
        }
    }

    @SuppressWarnings("unchecked")
    public static void displayStaffByAge() {
        /*
         * The allStaffList object is used to store the allStaffList object that is
         * returned from the getAdmin and getStaffList method.
         */
        ArrayList<User> allStaffList = new ArrayList<>();
        /*
         * The admin object is used to store the admin object that is returned from the
         * getAdmin method.
         */
        for (Admin admin : Company.getAdmin()) {
            allStaffList.add(admin);
        }
        /*
         * The branch object is used to store the branch object that is returned from
         * the
         * getBranch method.
         */
        for (Branch branch : Company.getBranch().values()) {
            /*
             * The staff object is used to store the staff object that is returned from the
             * getStaffList method.
             */
            for (Staff staff : branch.getStaffList()) {
                allStaffList.add(staff);
            }
        }

        Collections.sort(allStaffList);

        System.out.println("Filtered by Age");

        System.out.printf("%-7s", "AGE");
        System.out.printf("%-19s", "USERNAME");
        System.out.printf("%-13s", "LOGIN ID");
        System.out.printf("%-10s", "BRANCH");
        System.out.printf("%-10s", "ROLE");
        System.out.printf("%-8s %n", "GENDER");

        /*
         * The allStaffList object is used to store the allStaffList object that is
         * returned from the getAdmin and getStaffList method.
         */
        for (User user : allStaffList) {
            /*
             * The admin object is used to store the admin object that is returned from the
             * getAdmin method.
             */
            if (user instanceof Admin) {
                /*
                 * The tempAdmin object is used to store the tempAdmin object that is returned
                 * from the getAdmin method.
                 */
                Admin tempAdmin = (Admin) user;

                System.out.printf("%-7s", tempAdmin.getAge());
                System.out.printf("%-19s", tempAdmin.getUserName());
                System.out.printf("%-13s", tempAdmin.getUserId());
                System.out.printf("%-10s", "Company");
                System.out.printf("%-10s", tempAdmin.getRole());
                System.out.printf("%-8s %n", tempAdmin.getGender());
            } else {
                /*
                 * The staff object is used to store the staff object that is returned from the
                 * getStaffList method.
                 */
                Staff staff = (Staff) user;

                System.out.printf("%-7s", staff.getAge());
                System.out.printf("%-19s", staff.getUserName());
                System.out.printf("%-13s", staff.getUserId());
                System.out.printf("%-10s", staff.getBranchName());
                System.out.printf("%-10s", staff.getRole());
                System.out.printf("%-8s %n", staff.getGender());
            }
        }
        System.out.println("");
    }

    /**
     * The transferStaff method is used to transfer the staff to another branch
     * 
     * @param staff     The staff object
     * @param branchKey The branch key
     * @throws StaffExistException
     * @throws AddStaffException
     */
    public static void addStaff(Staff staff, Branch branch) throws StaffExistException, AddStaffException {
        try {
            /*
             * The tempStaff object is used to store the staff object that is returned from
             * the checkValid method.
             */
            ArrayList<Staff> temStaffs = branch.getStaffList();
            /*
             * The role object is used to store the role object that is returned from the
             * getRole method.
             */
            Role role = staff.getRole();

            for (int i = 0; i < temStaffs.size(); i++) {
                if (temStaffs.get(i).getUserId().equals(staff.getUserId()))
                    throw new StaffExistException();
            }
            /*
             * The quota object is used to store the quota object that is returned from the
             * getStaffQuota method.
             */
            int quota = 0;
            if (role.equals(Role.MANAGER)) {
                quota = (branch.getNumStaff() + 3) / 4;
                if (branch.getNumManager() >= quota)
                    throw new AddStaffException("Manager limit reached");
            } else {
                quota = branch.getStaffQuota();
                if (branch.getNumStaff() >= quota)
                    throw new AddStaffException("Staff limit reached");
            }
            /*
             * The temStaffs object is used to store the temStaffs object that is returned
             * from the getStaffList method.
             */
            temStaffs.add(staff);
            branch.setStaffList(temStaffs);

            /*
             * The numStaff object is used to store the numStaff object that is returned
             * from
             * the getNumStaff method.
             */
            int numStaff = branch.getNumStaff();
            int numManager = branch.getNumManager();

            if (role.equals(Role.MANAGER)) {
                numManager += 1;
            } else
                numStaff += 1;

            branch.setNumManager(numManager);
            branch.setNumStaff(numStaff);

            // write to database, to be implemented
            /*
             * The table object is used to store the table object that is returned from the
             * readFile method.
             */
            ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/staff_list_updated.xlsx", 6);
            Object[] toWrite = new Object[6];

            toWrite[0] = staff.getUserName();
            toWrite[1] = staff.getUserId();
            toWrite[2] = (role == Role.STAFF) ? "S" : "M";
            toWrite[3] = staff.getGender();
            toWrite[4] = (double) staff.getAge();
            toWrite[5] = branch.getBranchName();

            table.add(toWrite);

            /*
             * The writeFile method is used to write the table object to the microsoft excel
             * file.
             */
            boolean success = ExcelReaderWriter.writeFile(table, "data/staff_list_updated.xlsx", 6);

            return;
        } catch (IOException | InvalidFormatException e) {
            // Handle the exceptions
            e.printStackTrace(); // or any other error handling mechanism
            // Optionally, rethrow the exception if you want the caller to handle it
            // throw e;
        }
    }

    /**
     * The deleteStaff method is used to delete the staff
     * 
     * @param staff The staff object
     */
    public static void deleteStaff(Staff staff) {
        try {
            /*
             * The branchName object is used to store the branchName object that is returned
             * from the getBranchName method.
             */
            String branchName = staff.getBranchName();
            Branch branch = Company.getBranch().get(branchName);
            /*
             * The temStaffs object is used to store the temStaffs object that is returned
             * from the getStaffList method.
             */
            ArrayList<Staff> temStaffs = branch.getStaffList();
            temStaffs.remove(staff);
            branch.setStaffList(temStaffs);

            /*
             * @param numStaff The number of staff in the branch.
             * 
             * @param numManager The number of manager in the branch.
             */
            int numStaff = branch.getNumStaff();
            int numManager = branch.getNumManager();

            if (staff.getRole().equals(Role.MANAGER)) {
                numManager -= 1;
            } else
                numStaff -= 1;

            branch.setNumManager(numManager);
            branch.setNumStaff(numStaff);

            // write to database, to be implemented
            /*
             * The table object is used to store the table object that is returned from the
             * readFile method.
             */
            ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/staff_list_updated.xlsx", 6);

            /*
             * The role object is used to store the role object that is returned from the
             * getRole method.
             */
            Role role = staff.getRole();
            Object[] toDelete = new Object[6];

            toDelete[0] = staff.getUserName();
            toDelete[1] = staff.getUserId();
            toDelete[2] = (role == Role.STAFF) ? "S" : "M";
            toDelete[3] = staff.getGender();
            toDelete[4] = (double) staff.getAge();
            toDelete[5] = branch.getBranchName();

            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[1].equals(toDelete[1])) {
                    table.remove(i);
                    break;
                }
            }

            ExcelReaderWriter.writeFile(table, "data/staff_list_updated.xlsx", 6);
        } catch (IOException | InvalidFormatException e) {
            // Handle the exceptions
            e.printStackTrace(); // or any other error handling mechanism
            // Optionally, rethrow the exception if you want the caller to handle it
            // throw e;
        }
    }
}