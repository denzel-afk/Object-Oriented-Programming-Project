package entity;

import java.util.*;

/**
 * Branch class is used to store the information of a branch, including
 * branchName, location,
 * staffQuota, mgrQuota, numStaff, numManager, staffList, menuItems, orders.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * 
 * @version 2.0
 * @since 2024-04-26
 */
public class Branch {

	/**
	 * the name of the branch
	 */
	private String branchName;

	/**
	 * the location of the branch
	 */
	private String location;

	/**
	 * the maximum number of staff allowed in the branch
	 */
	private int staffQuota;

	/**
	 * the maximum number of managers allowed in the branch
	 */
	private int mgrQuota;

	/**
	 * the current number of staff in the branch
	 */
	private int numStaff = 0;

	/**
	 * the current number of manager in the branch
	 */
	private int numManager = 0;

	/**
	 * the list of staff in the branch
	 */
	private ArrayList<Staff> staffList;

	/**
	 * the list of menu items in the branch
	 */
	private ArrayList<MenuItem> menuItems;

	/**
	 * the list of orders in the branch
	 */
	private HashMap<String, Order> orders;

	/**
	 * Constructs a new Branch object with the specified parameters.
	 * 
	 * @param branchName the name of the branch.
	 * @param location   the location of the branch.
	 */
	public Branch(String branchName, String location) {
		this.branchName = branchName;
		this.location = location;
		this.staffQuota = 4;
		this.mgrQuota = 1;
		this.staffList = new ArrayList<>();
		this.menuItems = new ArrayList<>();
		this.orders = new HashMap<String, Order>();
	}

	/**
	 * Constructs a new Branch object with the specified parameters.
	 * 
	 * @param branchName the name of the branch.
	 * @param location   the location of the branch.
	 * @param staffQuota the maximum number of staff allowed in the branch.
	 */
	public Branch(String branchName, String location, int staffQuota) {
		this.branchName = branchName;
		this.location = location;
		this.staffQuota = staffQuota;
		this.mgrQuota = (staffQuota + 3) / 4;
		this.staffList = new ArrayList<>();
		this.menuItems = new ArrayList<>();
		this.orders = new HashMap<String, Order>();
	}

	/**
	 * Get the list of staff in the branch.
	 * 
	 * @return the list of staff in the branch.
	 */
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	/**
	 * Set the list of staff in the branch.
	 * 
	 * @param staffList the list of staff in the branch.
	 */
	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}

	/**
	 * Get the name of the branch.
	 * 
	 * @return the name of the branch.
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Set the name of the branch.
	 * 
	 * @param branchName the name of the branch.
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Get the location of the branch.
	 * 
	 * @return the location of the branch.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Set the location of the branch.
	 * 
	 * @param location the location of the branch.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Get the maximum number of staff allowed in the branch.
	 * 
	 * @return the maximum number of staff allowed in the branch.
	 */
	public int getStaffQuota() {
		return staffQuota;
	}

	/**
	 * Set the maximum number of staff allowed in the branch.
	 * 
	 * @param staffQuota the maximum number of staff allowed in the branch.
	 */
	public void setStaffQuota(int staffQuota) {
		this.staffQuota = staffQuota;
	}

	/**
	 * Get the maximum number of managers allowed in the branch.
	 * 
	 * @return the maximum number of managers allowed in the branch.
	 */
	public int getMgrQuota() {
		return mgrQuota;
	}

	/**
	 * Set the maximum number of managers allowed in the branch.
	 * 
	 * @param mgrQuota the maximum number of managers allowed in the branch.
	 */
	public void setMgrQuota(int mgrQuota) {
		this.mgrQuota = mgrQuota;
	}

	/**
	 * Get the list of menu items in the branch.
	 * 
	 * @return the list of menu items in the branch.
	 */
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	/**
	 * Set the list of menu items in the branch.
	 * 
	 * @param menuItems the list of menu items in the branch.
	 */
	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	/**
	 * Get the list of orders in the branch.
	 * 
	 * @return the list of orders in the branch.
	 */
	public HashMap<String, Order> getOrders() {
		return orders;
	}

	/**
	 * Set the list of orders in the branch.
	 * 
	 * @param orders the list of orders in the branch.
	 */
	public void setOrders(HashMap<String, Order> orders) {
		this.orders = orders;
	}

	/**
	 * Get the current number of staff in the branch.
	 * 
	 * @return the current number of staff in the branch.
	 */
	public int getNumStaff() {
		return this.numStaff;
	}

	/**
	 * Set the current number of staff in the branch.
	 * 
	 * @param numStaff the current number of staff in the branch.
	 */
	public void setNumStaff(int numStaff) {
		this.numStaff = numStaff;
	}

	/**
	 * Get the current number of managers in the branch.
	 * 
	 * @return the current number of managers in the branch.
	 */
	public int getNumManager() {
		return this.numManager;
	}

	/**
	 * Set the current number of managers in the branch.
	 * 
	 * @param numManager the current number of managers in the branch.
	 */
	public void setNumManager(int numManager) {
		this.numManager = numManager;
	}
}