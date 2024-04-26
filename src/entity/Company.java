package entity;

import java.util.*;

/**
 * This class is the entity class for Company
 * It contains the attributes of the Company
 * It contains the getter and setter methods for the attributes
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class Company {
    /**
     * @param branches The branches of the company with respective staffs
     * @param admins   The admins of the company
     */
    private static HashMap<String, Branch> branches = new HashMap<>();
    private static ArrayList<Admin> admins = new ArrayList<>();

    /**
     * This method is used to get the branches of the company
     * 
     * @return branches The branches of the company with respective staffs
     */
    public static HashMap<String, Branch> getBranch() {
        return branches;
    }

    /**
     * This method is used to set the branches of the company
     * 
     * @param branch The branches of the company with respective staffs
     */
    public static void setBranch(HashMap<String, Branch> branch) {
        Company.branches = branch;
    }

    /**
     * This method is used to get the admins of the company
     * 
     * @return admins The admins of the company
     */
    public static ArrayList<Admin> getAdmin() {
        return admins;
    }

    /**
     * This method is used to set the admins of the company
     * 
     * @param admin The admins of the company
     */
    public static void setAdmins(ArrayList<Admin> admin) {
        Company.admins = admin;
    }
}