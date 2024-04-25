package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static ArrayList<Object[]> readFile(String pathName, int noOfCols) {
        try {
            FileInputStream file = new FileInputStream(pathName);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            ArrayList<Object[]> entry = new ArrayList<Object[]>();

            for (Row row : sheet) {
                if (isRowEmpty(row))
                    break;

                Object[] colValue = new Object[noOfCols];

                for (int i = 0; i < noOfCols; i++) {
                    Cell cell = row.getCell(i);
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            colValue[i] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            colValue[i] = cell.getNumericCellValue();
                            break;
                        default:
                            colValue[i] = "-";
                    }
                }
                entry.add(colValue);
            }

            workbook.close();
            file.close();

            return entry;
        } catch (IOException e) {
            System.out.println("Failed to open file!");
            return null;
        }
    }

    public static boolean writeFile(ArrayList<Object[]> table, String pathName, int noOfCol) {
        try {
            // Create a temporary file
            String tempFileName = pathName + "_temp";
            FileOutputStream fout = new FileOutputStream(tempFileName);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();

            int size = table.size();

            // Create rows and write data
            for (int i = 0; i < size; i++) {
                Object[] col = table.get(i);
                Row row = sheet.createRow(i);

                for (int j = 0; j < noOfCol; j++) {
                    Cell cell = row.createCell(j);
                    if (col[j] instanceof Double)
                        cell.setCellValue((Double) col[j]);
                    else
                        cell.setCellValue((String) col[j]);
                }
            }

            workbook.write(fout);
            fout.close();
            workbook.close();

            // Replace original file with the temporary file
            File originalFile = new File(pathName);
            File tempFile = new File(tempFileName);
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Successfully written to file!");
                return true;
            } else {
                System.out.println("Failed to write to file!");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Failed to write to file!");
            return false;
        }
    }

    public static boolean isRowEmpty(Row row) {
        if (row == null || row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellTypeEnum() != CellType.BLANK && cell.getCellTypeEnum() != CellType._NONE) {
                return false;
            }
        }
        return true;
    }
}