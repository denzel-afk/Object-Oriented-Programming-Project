package entity;

public class User{
	private String userName;
	private String userId;
	private String password;
	private int age;
	private String gender;
	private Role role;
	
	public User(String userName, String userId, int age, String gender, Role role) {
	    this.userName = userName;
	    this.userId = userId;
	    this.password = "password"; 
	    this.age = age;
	    this.gender = gender;
	    this.role = role;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
	    return userName;
	}
	
	public void setUserName(String userName) {
	    this.userName = userName;
	}
	
	public String getUserId() {
	    return userId;
	}
	
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	
	public String getPassword() {
	    return password;
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}
	
	public int getAge() {
	    return age;
	}
	
	public void setAge(int age) {
	    this.age = age;
	}
	
	public String getGender() {
	    return gender;
	}
	
	public void setGender(String gender) {
	    this.gender = gender;
	}
}