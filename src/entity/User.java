package entity;

/**
 * The User class represents a user in the system.
 * Users have attributes such as name, ID, age, gender, and role.
 * Users can also be compared based on their age.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class User implements Comparable {

	/**
	 * the username of a user, it is unique for each user
	 */
	private String userName;
	/**
	 * the id of a user
	 */
	private String userId;
	/**
	 * the password of a user
	 */
	private String password;
	/**
	 * the age of a user
	 */
	private int age;
	/**
	 * the gender of a user
	 */
	private String gender;
	/**
	 * the role of a user, can be staff, manager, or admin
	 */
	private Role role;

	/**
	 * This constructor is used to create a new user
	 * 
	 * @param userName The name of the user
	 * @param userId   The id of the user
	 * @param age      The age of the user
	 * @param gender   The gender of the user
	 * @param role     The role of the user
	 */
	public User(String userName, String userId, int age, String gender, Role role) {
		this.userName = userName;
		this.userId = userId;
		this.password = "password";
		this.age = age;
		this.gender = gender;
		this.role = role;
	}

	/**
	 * This method is used to get the role of the user
	 * 
	 * @return the role of the user
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * This method is used to set the role of the user
	 * 
	 * @param role The role of the user
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * This method is used to get the username of the user
	 * 
	 * @return the name of the user
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method is used to set the username of the user
	 * 
	 * @param userName The name of the user
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method is used to get the id of the user
	 * 
	 * @return the id of the user
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method is used to set the id of the user
	 * 
	 * @param userId The id of the user
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method is used to get the password of the user
	 * 
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method is used to set the password of the user
	 * 
	 * @param password The password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method is used to get the age of the user
	 * 
	 * @return the age of the user
	 */
	public int getAge() {
		return age;
	}

	/**
	 * This method is used to set the age of the user
	 * 
	 * @param age The age of the user
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This method is used to get the gender of the user
	 * 
	 * @return the gender of the user
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method is used to set the gender of the user
	 * 
	 * @param gender The gender of the user
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * This method is used to compare the age of the user
	 * and sort the user based on the age
	 * 
	 * @return 1 if the age is greater than the other user
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof User) {
			User tempUser = (User) o;
			if (this.age > tempUser.age) {
				return 1;
			} else if (this.age < tempUser.age) {
				return -1;
			} else
				return 0;

		}
		return 0;
	}
}