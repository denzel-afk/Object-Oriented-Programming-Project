package entity;

import java.util.*;

/*
 * Order class to store the order details
 *	
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class Order {
	/*
	 * @param status the status of the order
	 * 
	 * @param orderItems the list of order items
	 * 
	 * @param timeElapsed the time elapsed since the order was placed
	 * 
	 * @param isTakeaway the boolean value to check if the order is takeaway
	 * 
	 * @param totalPrice the total price of the order
	 */
	private OrderStatus status;
	private ArrayList<OrderItem> orderItems;
	private long timeElapsed;
	private Boolean isTakeaway;
	private double totalPrice;

	/*
	 * This constructor is used to create a new order
	 * 
	 * @param isTakeaway The boolean value to check if the order is takeaway
	 */
	public Order(boolean isTakeaway) {
		this.isTakeaway = isTakeaway;
		status = OrderStatus.PENDING;
		orderItems = new ArrayList<OrderItem>();
	}

	/*
	 * This method is used to create a new order
	 * 
	 * @param isTakeaway The boolean value to check if the order is takeaway
	 */
	public OrderStatus getStatus() {
		return this.status;
	}

	/*
	 * This method is used to get the status of the order
	 * 
	 * @return status The status of the order
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/*
	 * This method is used to set the status of the order
	 * 
	 * @param status The status of the order
	 */
	public ArrayList<OrderItem> getItems() {
		return orderItems;
	}

	/*
	 * This method is used to get the list of order items
	 * 
	 * @return orderItems The list of order items
	 */
	public void setItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/*
	 * This method is used to set the list of order items
	 * 
	 * @param orderItems The list of order items
	 */
	public long getTimeElapsed() {
		return this.timeElapsed;
	}

	/*
	 * This method is used to get the time elapsed since the order was placed
	 * 
	 * @return timeElapsed The time elapsed since the order was placed
	 */
	public void setTimeElapsed(long timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	/*
	 * This method is used to set the time elapsed since the order was placed
	 * 
	 * @param timeElapsed The time elapsed since the order was placed
	 */
	public Boolean getIsTakeaway() {
		return this.isTakeaway;
	}

	/*
	 * This method is used to get the boolean value to check if the order is
	 * takeaway
	 * 
	 * @return isTakeaway The boolean value to check if the order is takeaway
	 */
	public void setIsTakeaway(Boolean isTakeaway) {
		this.isTakeaway = isTakeaway;
	}

	/*
	 * This method is used to set the boolean value to check if the order is
	 * takeaway
	 * 
	 * @param isTakeaway The boolean value to check if the order is takeaway
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/*
	 * This method is used to get the total price of the order
	 * 
	 * @return totalPrice The total price of the order
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}