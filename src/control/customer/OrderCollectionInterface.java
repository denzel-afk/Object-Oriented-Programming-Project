package control.customer;

/**
 * OrderCollectionInterface is an interface that is used to collect the order.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public interface OrderCollectionInterface {
    /**
     * This method is used to collect the order.
     * 
     * @param branchName The branch name where it is ordered.
     * @param id         The order ID.
     */
    public void collectOrder(String branchName, String id);
}
