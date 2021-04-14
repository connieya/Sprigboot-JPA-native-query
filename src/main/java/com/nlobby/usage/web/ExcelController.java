package com.nlobby.usage.web;

import com.nlobby.usage.model.ExcelPoI;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class ExcelController {

    private final RequestController requestController;

    @GetMapping("/api/nlobby/request/{date}")
    public Long nlobbyData(HttpServletResponse response ,
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {


        Long data = requestController.방문객신청현황(date);
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




        return data;



    }
}
