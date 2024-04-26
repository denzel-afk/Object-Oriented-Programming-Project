package entity;

/*
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
	/*
	 * The branch name of the staff
	 */
	private String branchName;

	/*
	 * Constructs a Staff object with the specified parameters.
	 */
	public Staff(String username, String userId, Role role, String branchName, int age, String gender) {
		super(username, userId, age, gender, role);
		this.branchName = branchName;
	}

	/*
	 * Get the branch name of the staff
	 * 
	 * @return the branch name of the staff
	 */
	public String getBranchName() {
		return branchName;
	}

	/*
	 * Set the branch name of the staff
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}