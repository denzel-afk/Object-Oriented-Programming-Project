package entity;

/**
 * The Admin class represents an administrator user in the system, extending the
 * User class.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class Admin extends User {
  /**
   * Constructs an Admin object with the specified parameters.
   *
   * @param userName the username of the administrator
   * @param userId   the unique identifier of the administrator
   * @param age      the age of the administrator
   * @param gender   the gender of the administrator
   */
  public Admin(String userName, String userId, int age, String gender) {
    super(userName, userId, age, gender, Role.ADMIN);
  }
}