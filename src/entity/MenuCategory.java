package entity;

/**
 * Enum class for representing the different categories of menu items.
 * Each category corresponds to a specific type of menu item.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public enum MenuCategory {

    /**
     * the set meal category
     */
    SET_MEAL,

    /**
     * the burger category
     */
    BURGER,

    /**
     * the side category
     */
    SIDE,

    /**
     * the drink category
     */
    DRINK;

    /**
     * Converts the enum name to a more readable format by replacing underscores
     * with spaces.
     * 
     * @return The enum name in a more readable format
     */
    public String toString() {
        return name().replaceAll("_", " "); // Convert enum name to a more readable format
    }
}