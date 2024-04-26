package control.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Branch;
import entity.Company;
import exception.BranchExistsException;
import exception.BranchNotExistException;
import exception.CloseBranchException;
import control.ExcelReaderWriter;

public class BranchOperationController {

    public static void openBranch(Branch branch) throws BranchExistsException {
        HashMap<String, Branch> temBranches = Company.getBranch();

        for (Map.Entry<String, Branch> e : temBranches.entrySet()) {
            if (e.getKey().equals(branch.getBranchName())) {
                throw new BranchExistsException();
            }
        }

        temBranches.put(branch.getBranchName(), branch);
        Company.setBranch(temBranches);

        ArrayList<Object[]> table = ExcelReaderWriter.readFile("data/branch_list_updated.xlsx", 3);
        Object[] toWrite = new Object[3];

        toWrite[0] = branch.getBranchName();
        toWrite[1] = branch.getLocation();
        toWrite[2] = (double) branch.getStaffQuota();

        table.add(toWrite);

        ExcelReaderWriter.writeFile(table, "data/branch_list_updated.xlsx", 3);
    }

    public static void closeBranch(Branch branch) throws CloseBranchException {

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

        ExcelReaderWriter.writeFile(table, "data/default_branch_list.xlsx", 3);
    }

}