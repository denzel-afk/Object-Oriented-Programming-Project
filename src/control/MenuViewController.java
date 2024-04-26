package control;

import java.util.ArrayList;

import entity.Branch;
import entity.Company;
import entity.MenuItem;
import exception.BranchNotExistException;
import exception.MenuException;

/**
 * MenuViewController class is used to control the menu view functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class MenuViewController {
    /**
     * This method is used to display the menu.
     * 
     * @param branchName The branch name.
     */
    public static void displayMenu(String branchName) {

        try {
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            ArrayList<MenuItem> menu = branch.getMenuItems();
            if (menu == null || menu.size() < 0)
                throw new MenuException();

            System.out.printf("\t%-15s\t%s\t%s\n", "Name", "Price", "Category");

            int i = 1;
            for (MenuItem item : menu) {
                System.out.printf("%d\t%-15s\t%.2f\t%s\n", i++, item.getItemName(), item.getPrice(),
                        item.getCategory());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}