package control;

import java.util.HashMap;
import java.util.Map;

import control.customer.OrderCheckOutInterface;
import control.customer.OrderCollectionInterface;
import entity.Branch;
import entity.Company;
import entity.Order;
import entity.OrderStatus;
import exception.BranchNotExistException;
import exception.OrderException;

/**
 * OrderStatusController class is used to control the order status functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class OrderStatusController
        implements OrderProcessingInterface, OrderCollectionInterface, OrderCheckOutInterface {

    /**
     * This method is used to process the order.
     * 
     * @param branchName The branch name.
     * @param id         The order ID.
     */
    public void processOrder(String branchName, String id) {
        try {
            /*
             * Check if the branch exists
             */
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            /*
             * Check if the order list is empty
             */
            HashMap<String, Order> orderList = Company.getBranch().get(branchName).getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            Order order = orderList.get(id);
            orderList.remove(id);

            // Process order
            if (order.getStatus() == OrderStatus.PENDING) {
                order.setStatus(OrderStatus.READY_TO_PICKUP);
                System.out.println("Order processed!");
            }

            orderList.put(id, order);
            branch.setOrders(orderList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to cancel the order.
     * 
     * @param branchName The branch name.
     */
    public static void cancelOrder(String branchName) {
        try {
            /*
             * Check if the branch exists
             */
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            /*
             * Check if the order list is empty or invalid
             */
            HashMap<String, Order> orderList = Company.getBranch().get(branchName).getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            /*
             * Cancel the order if the order is ready to pickup for more than 100000
             * milliseconds
             */
            for (Map.Entry<String, Order> e : orderList.entrySet()) {
                Order order = e.getValue();
                String key = e.getKey();

                /*
                 * Check if the order is ready to pickup for more than 100000 milliseconds
                 */
                if ((order.getStatus() == OrderStatus.READY_TO_PICKUP)
                        && (System.currentTimeMillis() - order.getTimeElapsed() > 100000)) {
                    orderList.remove(key);
                    order.setStatus(OrderStatus.CANCELLED);
                    orderList.put(key, order);
                }
            }

            branch.setOrders(orderList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to collect the order.
     * 
     * @param branchName The branch name.
     * @param id         The order ID.
     */
    public void collectOrder(String branchName, String id) {
        try {
            OrderStatusController.cancelOrder(branchName);

            /*
             * Check if the branch exists
             */
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            /*
             * Check if the order list is empty
             * 
             * @param orderList The order list.
             */
            HashMap<String, Order> orderList = branch.getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            Order order = orderList.get(id);
            orderList.remove(id);

            /*
             * Collect the order if the order is ready to pickup
             * 
             * @param order The order.
             */
            if (order.getStatus() == OrderStatus.READY_TO_PICKUP) {
                order.setStatus(OrderStatus.COMPLETED);
                System.out.println("Order collected!");
            } else if (order.getStatus() == OrderStatus.PENDING)
                System.out.println("Order not ready for collection!");
            else if (order.getStatus() == OrderStatus.CANCELLED)
                System.out.println("Order Cancelled!");

            orderList.put(id, order);
            branch.setOrders(orderList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to check out the order.
     * 
     * @param branchName The branch name.
     * @param id         The order ID.
     * @param paid       The boolean value to check if the order is paid.
     */
    public void checkOut(String branchName, String id, boolean paid) {

        try {
            /*
             * Check if the branch exists
             */
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            /*
             * Check if the order list is empty
             * 
             * @param orderList The order list.
             */
            HashMap<String, Order> orderList = branch.getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            Order order = orderList.get(id);
            orderList.remove(id);
            if (paid) {
                order.setStatus(OrderStatus.PENDING);
                order.setTimeElapsed(System.currentTimeMillis());
                System.out.println("Order sent to kitchen!");
            } else
                order.setStatus(OrderStatus.CANCELLED);

            orderList.put(id, order);
            branch.setOrders(orderList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}