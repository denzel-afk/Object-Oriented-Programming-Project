package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * ExcelReaderWriter class is used to read and write data from and to an Excel
 * file.
 * 
 * @author Denzel Elden Wijaya
 * @author Federrico Hansen Budianto
 * @author Melisa Lee
 * @author Rivaldo Billy Sebastian
 * @version 1.0
 * @since 2024-04-26
 */

public class ExcelReaderWriter {

    /**
     * The readFile method is used to read data from an Excel file.
     * 
     * @param pathName The path of the Excel file.
     * @param noOfCols The number of columns in the Excel file.
     * @return An ArrayList of Object[] containing the data read from the Excel
     *         file.
     */
    public static ArrayList<Object[]> readFile(String pathName, int noOfCols) {
        try {
            FileInputStream file = new FileInputStream(pathName);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            /*
             * ArrayList of Object[] to store the data read from the Excel file. Each
             * Object[]
             */
            ArrayList<Object[]> entry = new ArrayList<Object[]>();

            for (Row row : sheet) {
                if (isRowEmpty(row))
                    break;

                Object[] colValue = new Object[noOfCols];

                for (int i = 0; i < noOfCols; i++) {
                    Cell cell = row.getCell(i);
                    if (cell != null) {
                        CellType cellType = cell.getCellTypeEnum();
                        switch (cellType) {
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

    /**
     * The writeFile method is used to write data to an Excel file.
     * 
     * @param table    The data to be written to the Excel file.
     * @param pathName The path of the Excel file.
     * @param noOfCol  The number of columns in the Excel file.
     * @return A boolean value to indicate if the data has been successfully written
     *         to the Excel file.
     * @throws IOException            If an I/O error occurs.
     * @throws InvalidFormatException If the format of the Excel file is invalid.
     */
    public static boolean writeFile(ArrayList<Object[]> table, String pathName, int noOfCol)
            throws IOException, InvalidFormatException {
        try {
            /*
             * @param fin The FileInputStream.
             * 
             * @param workbook The Workbook.
             * 
             * @param sheet The Sheet.
             * 
             * @param size The size of the table.
             */
            FileInputStream fin = new FileInputStream(pathName);
            Workbook workbook = WorkbookFactory.create(fin);
            Sheet sheet = workbook.createSheet();
            workbook.removeSheetAt(0);

            int size = table.size();

            // Create row and write data
            for (int i = 0; i < size; i++) {
                Object[] col = table.get(i);
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);

                for (int j = 0; j < noOfCol; j++) {
                    Cell cell = row.createCell(j);
                    if (col[j] instanceof Double)
                        cell.setCellValue((Double) col[j]);
                    else
                        cell.setCellValue((String) col[j]);
                }
            }

            fin.close();

            /*
             * @param fout The FileOutputStream.
             * Write to file
             * 
             * @return true if the data has been successfully written to the Excel file,
             * false otherwise.
             * 
             * @throws IOException If an I/O error occurs.
             */
            FileOutputStream fout = new FileOutputStream(pathName);
            workbook.write(fout);
            fout.close();
            workbook.close();

            System.out.println("Successfully written to file!");
            return true;
        } catch (IOException e) {
            System.out.println("Failed to write to file!");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * The isRowEmpty method is used to check if a row is empty.
     * 
     * @param row The row to be checked.
     * @return A boolean value to indicate if the row is empty.
     */
    public static boolean isRowEmpty(Row row) {
        /*
         * @param cell The cell.
         * Check if the row is empty
         */
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