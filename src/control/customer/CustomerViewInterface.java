package control.customer;

/**
 * CustomerViewInterface is an interface that is used to view the order status
 * and order details.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public interface CustomerViewInterface {

    /**
     * This method is used to view the order status.
     * 
     * @param branchName The branch name where it is ordered.
     * @param orderID    The order ID.
     */
    public void viewOrderStatus(String branchName, String orderID);

    /**
     * This method is used to view the order details.
     * 
     * @param branchName The branch name where it is ordered.
     * @param orderID    The order ID.
     */
    public double viewOrderDetails(String branchName, String orderID);
}
