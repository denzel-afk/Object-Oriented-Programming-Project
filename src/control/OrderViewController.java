package control;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import control.customer.CustomerViewInterface;
import entity.Company;
import entity.Order;
import entity.OrderItem;
import exception.OrderException;
//import entity.Branch;

/**
 * OrderViewController class is used to control the order view functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class OrderViewController implements CustomerViewInterface, StaffViewInterface {
    /**
     * This method is used to view the order status.
     * 
     * @param branchName The branch name.
     * @param orderID    The order ID.
     */
    public void viewOrderStatus(String branchName, String orderID) {
        try {
            OrderStatusController.cancelOrder(branchName);

            /*
             * Check if the order list is empty
             */
            HashMap<String, Order> orderList = Company.getBranch().get(branchName).getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            if (!orderList.containsKey(orderID))
                throw new OrderException();
            Order order = orderList.get(orderID);
            System.out.println("Status: " + order.getStatus());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to view the order details.
     * 
     * @param branchName The branch name.
     * @param orderID    The order ID.
     * @return The total price of the order.
     */
    public double viewOrderDetails(String branchName, String orderID) {
        try {
            OrderStatusController.cancelOrder(branchName);

            /*
             * Check if the order list is empty
             */
            HashMap<String, Order> orderList = Company.getBranch().get(branchName).getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            if (!orderList.containsKey(orderID))
                throw new OrderException();
            Order order = orderList.get(orderID);

            ArrayList<OrderItem> orderItems = order.getItems();
            if (orderItems.size() <= 0)
                throw new OrderException("Cart Empty!");

            System.out.println("Order-ID: " + orderID);
            System.out.println("Status: " + order.getStatus());
            System.out.println("Takeaway: " + order.getIsTakeaway());

            System.out.printf("\t%-15s\t%s\t%s\n", "Name", "QTY", "Price");

            /*
             * Display the order details
             */
            int i = 1;
            for (OrderItem item : orderItems) {
                String name = item.getItem().getItemName();
                int qty = item.getQuantity();
                double price = item.getItem().getPrice();
                System.out.printf("%d\t%-15s\t%d\t%.2f\n", i++, name, qty, qty * price);

            }
            /*
             * @param total The total price of the order.
             */
            double total = order.getTotalPrice();
            System.out.printf("Total: %.2f\n", total);

            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * This method is used to view the new orders.
     * 
     * @param branchName The branch name.
     */
    public void viewNewOrders(String branchName) {
        try {
            /*
             * Check if the order list is empty
             */
            HashMap<String, Order> orderList = Company.getBranch().get(branchName).getOrders();
            if (orderList == null || orderList.size() <= 0)
                throw new OrderException();

            /*
             * Display the new orders
             */
            for (Map.Entry<String, Order> e : orderList.entrySet()) {
                viewOrderDetails(branchName, e.getKey());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}