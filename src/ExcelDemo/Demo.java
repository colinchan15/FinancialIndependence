package ExcelDemo;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

    public static void main (String[]args) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet1 = workbook.createSheet("Ripon");
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
