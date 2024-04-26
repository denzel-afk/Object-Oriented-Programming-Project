package entity;

/**
 * The OrderStatus enum represents the status of an order.
 * It contains the different statuses of an order.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public enum OrderStatus {

	/**
	 * The different statuses of an order
	 * 
	 * @param PENDING         The order is pending
	 * @param READY_TO_PICKUP The order is ready to be picked up
	 * @param COMPLETED       The order is completed
	 * @param CANCELLED       The order is cancelled
	 */
	PENDING,
	READY_TO_PICKUP,
	COMPLETED,
	CANCELLED
}