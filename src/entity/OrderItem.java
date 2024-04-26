package entity;

/**
 * The OrderItem class represents an item in an order.
 * It contains the item, quantity, and remarks of the item.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 * 
 */

public class OrderItem {
	/**
	 * @param item     the item in the order
	 * 
	 * @param quantity the quantity of the item
	 * 
	 * @param remarks  the remarks of the item
	 */
	private MenuItem item;
	private int quantity;
	private String remarks;

	/**
	 * This constructor is used to create a new order item
	 * 
	 * @param item     The item in the order
	 * @param quantity The quantity of the item
	 * @param remarks  The remarks of the item
	 */
	public OrderItem(MenuItem item, int quantity, String remarks) {
		this.item = item;
		this.quantity = quantity;
		this.remarks = remarks;
	}

	/**
	 * This method is used to set the item in the order
	 * 
	 * @param item The item in the order
	 */
	public void setItem(MenuItem item) {
		this.item = item;
	}

	/**
	 * This method is used to get the item in the order
	 * 
	 * @return item The item in the order
	 */
	public MenuItem getItem() {
		return item;
	}

	/**
	 * This method is used to set the quantity of the item
	 * 
	 * @param quantity The quantity of the item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method is used to get the quantity of the item
	 * 
	 * @return quantity The quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * This method is used to set the remarks of the item
	 * 
	 * @param remarks The remarks of the item
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * This method is used to get the remarks of the item
	 * 
	 * @return remarks The remarks of the item
	 */
	public String getRemarks() {
		return remarks;
	}
}