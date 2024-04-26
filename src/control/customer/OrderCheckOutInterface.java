package control.customer;

/**
 * OrderCheckOutInterface is an interface that is used to check out the order.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public interface OrderCheckOutInterface {
    /**
     * This method is used to check out the order.
     * 
     * @param branchName The branch name.
     * @param id         The order ID.
     * @param send       The boolean value to check if the order is sent.
     */
    public void checkOut(String branchName, String id, boolean send);
}
