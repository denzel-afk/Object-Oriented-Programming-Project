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
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void openBranch(Branch branch) throws BranchExistsException {
        try {
            /*
             * The temBranches object is used to store the branches object that is returned
             * from the getBranch method.
             */
            HashMap<String, Branch> temBranches = Company.getBranch();

            for (Map.Entry<String, Branch> e : temBranches.entrySet()) {
                if (e.getKey().equals(branch.getBranchName())) {
                    throw new BranchExistsException();
                }
            }

            temBranches.put(branch.getBranchName(), branch);
            Company.setBranch(temBranches);

            /*
             * The table object is used to store the table object that is returned from the
             * readFile method.
             */
            ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/branch_list_updated.xlsx", 3);
            Object[] toWrite = new Object[3];

            toWrite[0] = branch.getBranchName();
            toWrite[1] = branch.getLocation();
            toWrite[2] = (double) branch.getStaffQuota();

            table.add(toWrite);

            /*
             * The writeFile method is used to write the table object to the microsoft excel
             * file.
             */
            ExcelReaderWriter.writeFile(table, "data/branch_list_updated.xlsx", 3);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * The displayStaffByBranch method is used to display the staff by branch
     */
    public static void closeBranch(Branch branch) throws CloseBranchException {
        try {
            HashMap<String, Branch> temBranches = Company.getBranch();

            for (Map.Entry<String, Branch> e : temBranches.entrySet()) {
                if (e.getKey().equals(branch.getBranchName())) {
                    Branch temBranch = e.getValue();
                    if (temBranch.getNumStaff() > 0 || temBranch.getNumManager() > 0)
                        throw new CloseBranchException();
                    temBranches.remove(e.getKey());
                    break;
                }
            }

            Company.setBranch(temBranches);

            /*
             * The table object is used to store the table object that is returned from the
             * readFile method.
             */
            ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/branch_list_updated.xlsx", 3);
            Object[] toWrite = new Object[3];

            toWrite[0] = branch.getBranchName();
            toWrite[1] = branch.getLocation();
            toWrite[2] = (double) branch.getStaffQuota();

            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)[0].equals(toWrite[0])) {
                    table.remove(i);
                    break;
                }
            }
            /*
             * The writeFile method is used to write the table object to the microsoft excel
             * file.
             */
            ExcelReaderWriter.writeFile(table, "data/default_branch_list.xlsx", 3);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}