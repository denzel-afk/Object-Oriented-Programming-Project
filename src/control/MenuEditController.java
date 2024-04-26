package control;

import java.util.ArrayList;

import entity.Branch;
import entity.Company;
import entity.MenuCategory;
import entity.MenuItem;
import entity.Staff;
import exception.BranchNotExistException;
import exception.MenuException;

/**
 * MenuEditController class is used to control the menu editing functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

// Control
public class MenuEditController {

    /**
     * @param pathName The path name of the file.
     */
    private static final String pathName = "data/menu_list_updated.xlsx";

    /**
     * This method is used to add a menu item.
     * 
     * @param branchName The branch name.
     * @param name       The menu item name.
     * @param price      The menu item price.
     * @param option     The menu category.
     */
    public static void addMenuItem(String branchName, String name, double price, int option) {
        try {
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            ArrayList<MenuItem> menu = branch.getMenuItems();
            if (menu == null)
                throw new MenuException();

            for (MenuItem item : menu) {
                if (name.equals(item.getItemName()))
                    throw new MenuException("Menu item already exist!");
                break;
            }

            if (option < 1 || option > MenuCategory.values().length)
                throw new ArrayIndexOutOfBoundsException("Invalid Menu Category!");
            MenuItem item = new MenuItem(name, MenuCategory.values()[option - 1], price);
            menu.add(item);
            branch.setMenuItems(menu);

            ArrayList<Object[]> table = ExcelReaderWriter.readFile(pathName, 4);
            Object[] toWrite = new Object[4];

            toWrite[0] = name;
            toWrite[1] = price;
            toWrite[2] = branchName;
            toWrite[3] = String.valueOf(MenuCategory.values()[option - 1]);

            table.add(toWrite);

            ExcelReaderWriter.writeFile(table, pathName, 4);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to edit the menu item name.
     * 
     * @param branchName The branch name.
     * @param index      The index.
     * @param name       The menu item name.
     */
    public static void editMenuItemName(String branchName, int index, String name) {
        try {
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            ArrayList<MenuItem> menu = branch.getMenuItems();
            if (menu == null || menu.size() < 0)
                throw new MenuException();

            for (MenuItem item : menu) {
                if (name == item.getItemName())
                    throw new MenuException("Menu name used!");
            }

            if (index > menu.size())
                throw new MenuException("Row number invalid!");

            MenuItem item = menu.get(index - 1);

            ArrayList<Object[]> table = ExcelReaderWriter.readFile(pathName, 4);
            Object[] toDelete = new Object[4];

            toDelete[0] = item.getItemName();
            toDelete[1] = item.getPrice();
            toDelete[2] = branchName;
            toDelete[3] = String.valueOf(item.getCategory());

            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[0].equals(toDelete[0]) && table.get(i)[2].equals(toDelete[2])) {
                    table.remove(i);
                    break;
                }
            }

            Object[] toWrite = new Object[4];

            toWrite[0] = name;
            toWrite[1] = toDelete[1];
            toWrite[2] = branchName;
            toWrite[3] = toDelete[3];

            table.add(toWrite);

            ExcelReaderWriter.writeFile(table, pathName, 4);

            item.setItemName(name);
            menu.set(index - 1, item);
            branch.setMenuItems(menu);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to edit the menu item price.
     * 
     * @param branchName The branch name.
     * @param index      The index.
     * @param price      The menu item price.
     */
    public static void editMenuItemPrice(String branchName, int index, double price) {
        try {
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            ArrayList<MenuItem> menu = branch.getMenuItems();
            if (menu == null || menu.size() < 0)
                throw new MenuException();

            if (index > menu.size())
                throw new MenuException("Row number invalid!");

            MenuItem item = menu.get(index - 1);

            ArrayList<Object[]> table = ExcelReaderWriter.readFile(pathName, 4);
            Object[] toDelete = new Object[4];

            toDelete[0] = item.getItemName();
            toDelete[1] = item.getPrice();
            toDelete[2] = branchName;
            toDelete[3] = String.valueOf(item.getCategory());

            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[0].equals(toDelete[0]) && table.get(i)[2].equals(toDelete[2])) {
                    table.remove(i);
                    break;
                }
            }
            Object[] toWrite = new Object[4];

            toWrite[0] = toDelete[0];
            toWrite[1] = price;
            toWrite[2] = branchName;
            toWrite[3] = toDelete[3];

            table.add(toWrite);

            ExcelReaderWriter.writeFile(table, pathName, 4);

            item.setPrice(price);
            menu.set(index - 1, item);
            branch.setMenuItems(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to edit the menu item category.
     * 
     * @param branchName The branch name.
     * @param index      The index.
     * @param option     The menu category.
     */
    public static void editMenuItemCategory(String branchName, int index, int option) {
        try {
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            ArrayList<MenuItem> menu = branch.getMenuItems();
            if (menu == null || menu.size() < 0)
                throw new MenuException();

            if (index > menu.size())
                throw new MenuException("Row number invalid!");
            if (option < 1 || option > MenuCategory.values().length)
                throw new ArrayIndexOutOfBoundsException("Invalid Menu Category!");
            MenuItem item = menu.get(index - 1);

            ArrayList<Object[]> table = ExcelReaderWriter.readFile(pathName, 4);
            Object[] toDelete = new Object[4];

            toDelete[0] = item.getItemName();
            toDelete[1] = item.getPrice();
            toDelete[2] = branchName;
            toDelete[3] = String.valueOf(item.getCategory());

            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[0].equals(toDelete[0]) && table.get(i)[2].equals(toDelete[2])) {
                    table.remove(i);
                    break;
                }
            }
            Object[] toWrite = new Object[4];

            toWrite[0] = toDelete[0];
            toWrite[1] = toDelete[1];
            toWrite[2] = branchName;
            toWrite[3] = MenuCategory.values()[option - 1];

            table.add(toWrite);

            ExcelReaderWriter.writeFile(table, pathName, 4);

            item.setCategory(MenuCategory.values()[option - 1]);
            menu.set(index - 1, item);
            branch.setMenuItems(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to remove a menu item.
     * 
     * @param branchName The branch name.
     * @param index      The index.
     */
    public static void removeMenuItem(String branchName, int index) {
        try {
            Branch branch = Company.getBranch().get(branchName);
            if (branch == null)
                throw new BranchNotExistException();

            ArrayList<MenuItem> menu = branch.getMenuItems();
            if (menu == null || menu.size() < 0)
                throw new MenuException();

            if (index > menu.size())
                throw new MenuException("Row number invalid!");

            MenuItem item = menu.get(index - 1);

            ArrayList<Object[]> table = ExcelReaderWriter.readFile(pathName, 4);

            Object[] toDelete = new Object[4];

            toDelete[0] = item.getItemName();
            toDelete[1] = item.getPrice();
            toDelete[2] = branchName;
            toDelete[3] = String.valueOf(item.getCategory());

            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[0].equals(toDelete[0]) && table.get(i)[2].equals(toDelete[2])) {
                    table.remove(i);
                    break;
                }
            }
            ExcelReaderWriter.writeFile(table, pathName, 4);

            menu.remove(index - 1);
            branch.setMenuItems(menu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}