package entity;

/**
 * Staff class
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * 
 * @version 1.0
 * @since 2024-04-26
 */
public class Staff extends User {
	/**
	 * the branch name where the staff is working at
	 */
	private String branchName;

	/**
	 * Constructs a Staff object with the specified parameters.
	 * 
	 * @param username   The username of the staff
	 * @param userId     The unique identifier of the staff
	 * @param role       The role of the staff
	 * @param branchName The branch name of the staff
	 * @param age        The age of the staff
	 * @param gender     The gender of the staff
	 */
	public Staff(String username, String userId, Role role, String branchName, int age, String gender) {
		super(username, userId, age, gender, role);
		this.branchName = branchName;
	}

	/**
	 * Get the branch name where the staff is working at
	 * 
	 * @return the branch name of the staff
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Set the branch name where the staff is working at
	 * 
	 * @param branchName the branch name of the staff
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}