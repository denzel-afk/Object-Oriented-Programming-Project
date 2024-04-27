package entity;

import java.util.*;

/**
 * This class is the entity class for a Company.
 * It contains the attributes and methods related to the Company.
 * The Company class manages branches and admins within the company.
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
     * The branches of the company with respective staffs.
     */
    private static HashMap<String, Branch> branches = new HashMap<>();
    
    /**
     * The admins of the company.
     */
    private static ArrayList<Admin> admins = new ArrayList<>();

    /**
     * This method is used to get the branches of the company
     * 
     * @return the branches of the company with respective staffs
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
     * @return the admins of the company
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