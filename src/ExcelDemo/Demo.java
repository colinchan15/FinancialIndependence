package ExcelDemo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

    public static void main (String[]args) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Ripon");
            Row row = sheet.createRow(0);
            Cell cell = row.createCell (0);
            cell.setCellValue(3.5);
            FileOutputStream out = new FileOutputStream(new File("C:/Users/colin/ideaProjects/FinancialIndependence/ExcelDemo.xlsx"));
            workbook.write(out);
            out.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println("Excel file outputted");
    }
}
