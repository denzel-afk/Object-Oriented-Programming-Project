package entity;

/*
 * entity is the package containing the classes that represent the data of the system.
 * It contains the classes that represent the data of the system.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class User implements Comparable {
	/*
	 * @param userName the name of the user
	 * 
	 * @param userId the id of the user
	 * 
	 * @param password the password of the user
	 * 
	 * @param age the age of the user
	 * 
	 * @param gender is the gender of the user
	 * 
	 * @param role is the role of the user
	 */
	private String userName;
	private String userId;
	private String password;
	private int age;
	private String gender;
	private Role role;

	/*
	 * This constructor is used to create a new user
	 */
	public User(String userName, String userId, int age, String gender, Role role) {
		this.userName = userName;
		this.userId = userId;
		this.password = "password";
		this.age = age;
		this.gender = gender;
		this.role = role;
	}

	/*
	 * This method is used to get the role of the user
	 * 
	 * @return role The role of the user
	 */
	public Role getRole() {
		return role;
	}

	/*
	 * This method is used to set the role of the user
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/*
	 * This method is used to get the name of the user
	 * 
	 * @return userName The name of the user
	 */
	public String getUserName() {
		return userName;
	}

	/*
	 * This method is used to set the name of the user
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * This method is used to get the id of the user
	 * 
	 * @return userId The id of the user
	 */
	public String getUserId() {
		return userId;
	}

	/*
	 * This method is used to set the id of the user
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * This method is used to get the password of the user
	 * 
	 * @return password The password of the user
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * This method is used to set the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * This method is used to get the age of the user
	 * 
	 * @return age The age of the user
	 */
	public int getAge() {
		return age;
	}

	/*
	 * This method is used to set the age of the user
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * This method is used to get the gender of the user
	 * 
	 * @return gender The gender of the user
	 */
	public String getGender() {
		return gender;
	}

	/*
	 * This method is used to set the gender of the user
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * This method is used to compare the age of the user
	 * and sort the user based on the age
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