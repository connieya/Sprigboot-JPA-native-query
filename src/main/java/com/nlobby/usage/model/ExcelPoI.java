package com.nlobby.usage.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelPoI {

    public static void exelPoI(Long data) {

        try {
            FileInputStream inputStream = new FileInputStream("C:\\summernote/nlobby_report.xls");
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            Cell cell = sheet.getRow(20).getCell(3);
            cell.setCellValue(data);
            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("C:\\summernote/nlobby_report.xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
