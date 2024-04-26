package entity;

/*
    * This class is an enum class that represents the different categories of menu items
    * It contains the different categories of menu items

    * @author Denzel Elden Wijaya
    * @author Federrico Hansen Budianto
    * @author Melisa Lee
    * @author Rivaldo Billy Sebastian
    * @version 1.0
    * @since 2024-04-26
 */
public enum MenuCategory {

    /*
     * The different categories of menu items
     */
    SET_MEAL,
    BURGER,
    SIDE,
    DRINK;

    /*
     * This method is used to convert the enum name to a more readable format
     */
    public String toString() {
        return name().replaceAll("_", " "); // Convert enum name to a more readable format
    }
}