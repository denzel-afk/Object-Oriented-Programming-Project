package control.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import entity.Branch;
import entity.Company;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.CloseBranchException;
import control.ExcelReaderWriter;

/**
 * AdminController class is used to control the admin functions
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class BranchOperationController {

    /**
     * Opens a new branch and updates the branch list.
     *
     * @param branch The branch to be opened.
     * @throws BranchExistsException If a branch with the same name already exists.
     */
    public static void openBranch(Branch branch) throws BranchExistsException {
        try {
            HashMap<String, Branch> tempBranches = Company.getBranch();

            // Check if the branch already exists
            for (Map.Entry<String, Branch> entry : tempBranches.entrySet()) {
                if (entry.getKey().equals(branch.getBranchName())) {
                    throw new BranchExistsException();
                }
            }

            // Add the new branch to the list of branches
            tempBranches.put(branch.getBranchName(), branch);
            Company.setBranch(tempBranches);

            // Update the branch list file
            ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/branch_list_updated.xlsx", 3);
            Object[] data = new Object[3];
            data[0] = branch.getBranchName();
            data[1] = branch.getLocation();
            data[2] = (double) branch.getStaffQuota();
            table.add(data);
            ExcelReaderWriter.writeFile(table, "data/branch_list_updated.xlsx", 3);
        } catch (IOException | InvalidFormatException e) {
            // Handle file IO or format exceptions
            e.printStackTrace();
        }
    }

    /**
     * Closes a branch and updates the branch list.
     *
     * @param branch The branch to be closed.
     * @throws CloseBranchException If the branch cannot be closed due to remaining
     *                              staff or managers.
     */
    public static void closeBranch(Branch branch) throws CloseBranchException {
        try {
            HashMap<String, Branch> tempBranches = Company.getBranch();

            // Check if the branch exists and has no remaining staff or managers
            for (Map.Entry<String, Branch> entry : tempBranches.entrySet()) {
                if (entry.getKey().equals(branch.getBranchName())) {
                    Branch tempBranch = entry.getValue();
                    if (tempBranch.getNumStaff() > 0 || tempBranch.getNumManager() > 0) {
                        throw new CloseBranchException();
                    }
                    tempBranches.remove(entry.getKey());
                    break;
                }
            }

            // Update the branch list
            Company.setBranch(tempBranches);

            // Update the branch list file
            ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/branch_list_updated.xlsx", 3);
            Object[] data = new Object[3];
            data[0] = branch.getBranchName();
            data[1] = branch.getLocation();
            data[2] = (double) branch.getStaffQuota();
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[0].equals(data[0])) {
                    table.remove(i);
                    break;
                }
            }
            ExcelReaderWriter.writeFile(table, "data/default_branch_list.xlsx", 3);
        } catch (IOException | InvalidFormatException e) {
            // Handle file IO or format exceptions
            e.printStackTrace();
        }
    }
}