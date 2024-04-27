package entity;

import java.util.*;

/**
 * Order class to store the order details.
 * 
 * Represents an order placed by a customer, including the status, order items,
 * time elapsed since order placement,
 * whether it is takeaway or dine-in, and total price.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public class Order {
	/**
	 * The status of the order.
	 */
	private OrderStatus status;

	/**
	 * The list of order items.
	 */
	private ArrayList<OrderItem> orderItems;

	/**
	 * The time elapsed since the order was placed and paid.
	 */
	private long timeElapsed;

	/**
	 * Indicates whether the order is for takeaway.
	 */
	private Boolean isTakeaway;

	/**
	 * The total price of the order.
	 */
	private double totalPrice;

	/**
	 * Constructs a new order object.
	 * 
	 * @param isTakeaway Indicates whether the order is for takeaway or dine-in
	 */
	public Order(boolean isTakeaway) {
		this.isTakeaway = isTakeaway;
		status = OrderStatus.PENDING;
		orderItems = new ArrayList<OrderItem>();
	}

	/**
	 * This method is used to check the status of an order
	 * 
	 * @return the new order status
	 */
	public OrderStatus getStatus() {
		return this.status;
	}

	/**
	 * This method is used to set the status of an order
	 * 
	 * @param status The status of the order
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/**
	 * This method is used to get the list of items ordered by a customer
	 * 
	 * @return the list of order items
	 */
	public ArrayList<OrderItem> getItems() {
		return orderItems;
	}

	/**
	 * This method is used to set the items that is ordered by a customer
	 * 
	 * @param orderItems The list of order items
	 */
	public void setItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * This method is used to get the time passed since the order is placed and paid
	 * if the time elapsed exceed the time limit, the order is canceled
	 * 
	 * @return the time elapsed since the order was placed
	 */
	public long getTimeElapsed() {
		return this.timeElapsed;
	}

	/**
	 * This method is used to set the time elapsed since the order was placed
	 * 
	 * @param timeElapsed The time elapsed since the order was placed
	 */
	public void setTimeElapsed(long timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	/**
	 * This method is used to set the time elapsed since the order was placed and
	 * paid
	 * 
	 * @return the boolean value to check if the order is takeaway
	 */
	public Boolean getIsTakeaway() {
		return this.isTakeaway;
	}

	/**
	 * This method is used to set the order to takeaway(1) or dine-in(0) option
	 * 
	 * @param isTakeaway The boolean value to indicate if an order is takeaway or
	 *                   not
	 */
	public void setIsTakeaway(Boolean isTakeaway) {
		this.isTakeaway = isTakeaway;
	}

	/**
	 * This method is used to get the total price of an order that must be paid
	 * 
	 * @return the total price of the order
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * This method is used to set the total price of an order that must be paid
	 * 
	 * @param totalPrice The total price of the order
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}