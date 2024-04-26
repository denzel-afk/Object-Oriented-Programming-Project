package control;

/**
 * OrderProcessingInterface is an interface that is used to process the order.
 * This interface is used to process the order.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */
public interface OrderProcessingInterface {
    /**
     * This method is used to process the order.
     * 
     * @param branchName The branch name.
     * @param id         The order ID.
     */
    public void processOrder(String branchName, String id);
}
