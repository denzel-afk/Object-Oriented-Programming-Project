package entity;

/**
 * Enum class representing the status of an order.
 * The OrderStatus enum contains different statuses for orders.
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
	 * The order is pending.
	 */
	PENDING,

	/**
	 * The order is ready to be picked up.
	 */
	READY_TO_PICKUP,

	/**
	 * The order is completed.
	 */
	COMPLETED,

	/**
	 * The order is cancelled.
	 */
	CANCELLED
}