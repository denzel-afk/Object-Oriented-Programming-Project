package entity;

/**
 * MenuItem class represents a menu item in the restaurant.
 * It stores details such as the name, category, and price of the menu item.
 * Provides getter and setter methods for accessing and modifying the
 * attributes.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * 
 * @version 1.0
 * @since 2024-04-26
 */
public class MenuItem {

	/**
	 * The name of the menu item.
	 */
	private String itemName;

	/**
	 * The category of the menu item.
	 */
	private MenuCategory category;

	/**
	 * The price of the menu item.
	 */
	private double price;

	/**
	 * This constructor is used to create a new menu item
	 * 
	 * @param itemName The name of the menu item
	 * @param category The category of the menu item
	 * @param price    The price of the menu item
	 */
	public MenuItem(String itemName, MenuCategory category, double price) {
		this.itemName = itemName;
		this.category = category;
		this.price = price;
	}

	/**
	 * This method is used to get the name of the menu item
	 * 
	 * @return the name of the menu item
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * This method is used to set the name of the menu item
	 * 
	 * @param itemName The name of the menu item
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * This method is used to get the category of the menu item
	 * 
	 * @return the category of the menu item
	 */
	public MenuCategory getCategory() {
		return category;
	}

	/**
	 * This method is used to set the category of the menu item
	 * 
	 * @param category The category of the menu item
	 */
	public void setCategory(MenuCategory category) {
		this.category = category;
	}

	/**
	 * This method is used to get the price of the menu item
	 * 
	 * @return the price of a particular menu item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This method is used to set the price of the menu item
	 * 
	 * @param price The price of the menu item
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}