package com.nlobby.usage.web;

import com.nlobby.usage.domain.AccessDto;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExcelController {

    private final RequestController requestController;
    private final AccessController accessController;
    private final SmsController smsController;
    private final NoticeController noticeController;
    private final HostController hostController;

    @CrossOrigin
    @RequestMapping("/api/nlobby/request/{date}/report.xls")
    public ServletOutputStream nlobbyData(HttpServletResponse response,
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) throws IOException {



        Long request = requestController.방문객신청현황(date);
        Long requestReserve = requestController.임직원신청현황(date);
        Long requestCar = requestController.방문객차량신청현황(date);
        Long requestCarReserve = requestController.임직원차량신청현황(date);

        Long visit = accessController.방문인원현황(date);
        Long visitNot = accessController.미방문인원현황(date);
        Long visitCar = accessController.방문차량현황(date);
        Long visitNotCar = accessController.미방문차량현황(date);

        String visitMax = accessController.방문인원최대시간(date);
        String visitAvg = accessController.방문인원평균시간(date);
        String visitCarMax = accessController.방문차량최대시간(date);
        String visitCarAvg = accessController.방문차량평균시간(date);

        Long entranceMax = accessController.출입인원최대(date);
        Long entranceAvg = accessController.출입인원평균(date);
        Long entranceCarMax = accessController.출입차량최대(date);
        Long entranceCarAvg = accessController.출입차량평균(date);
        List<AccessDto> carList = accessController.차량일별방문현황(date);
        List<AccessDto> accesslist = accessController.인원일별방문현황(date);

        Long noticeCount = noticeController.알림톡갯수(date);
        Long sms = smsController.SMS갯수(date);

        Long userCount = hostController.사용자수();
        try {
            FileInputStream inputStream = new FileInputStream("C:\\summernote/ttt.xls");
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            // 신청-방문현황  - 신청현황
            Row requestUsage = sheet.getRow(20);
            // 신청-방문현황  - 방문현황
            Row visitUsage = sheet.getRow(22);
            // 방문현황 분석 - 인원
            Row visitCount = sheet.getRow(27);
            // 방문현황 분석 - 차량
            Row visitCarCount = sheet.getRow(28);

            // 방문객 신청현황
            requestUsage.getCell(1).setCellValue(request);
            // 임직원 신청현황
            requestUsage.getCell(2).setCellValue(requestReserve);
            // 차량 신청현황
            requestUsage.getCell(4).setCellValue(requestCar);
            // 차량 임직원 신청현황
            requestUsage.getCell(5).setCellValue(requestCarReserve);

            // 인원 방문 현황
            visitUsage.getCell(1).setCellValue(visit);
            // 인원 미방문 현황
            visitUsage.getCell(2).setCellValue(visitNot);
            // 차량 방문 현황
            visitUsage.getCell(4).setCellValue(visitCar);
            // 차량 미방문 현황
            visitUsage.getCell(5).setCellValue(visitNotCar);

            // 체류 시간 인원 최대
            visitCount.getCell(1).setCellValue(visitMax);
            // 체류 시간 인원 평균
            visitCount.getCell(2).setCellValue(visitAvg);
            //출입 분석 -인원 최대
            visitCount.getCell(3).setCellValue(entranceMax);
            //출입 분석 -인원 평균
            visitCount.getCell(4).setCellValue(entranceAvg);

            //체류 시간 차량 최대
            visitCarCount.getCell(1).setCellValue(visitCarMax);
            //체류 시간 차량 평균
            visitCarCount.getCell(2).setCellValue(visitCarAvg);
            // 출입 문석 차량 최대
            visitCarCount.getCell(3).setCellValue(entranceCarMax);
            // 출입 분석 차량 평균
            visitCarCount.getCell(4).setCellValue(entranceCarAvg);

            // 알림톡 갯수
            sheet.getRow(26).getCell(6).setCellValue(noticeCount);
            // SMS 갯수
            visitCount.getCell(6).setCellValue(sms);
            inputStream.close();

            // 사용자 수
            sheet.getRow(4).getCell(6).setCellValue(userCount);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String formatDate = sdf.format(date);
            String year = formatDate.substring(0, 4);
            String month = formatDate.substring(5, formatDate.length());

            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 18);
            font.setFontName("맑은 고딕");
            font.setBold(true);

            CellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setFont(font);

            Cell header = sheet.getRow(0).getCell(0);
            header.setCellStyle(style);
            header.setCellValue(year+"년 "+month+"월 서비스 이용현황");


            for (int k = 40; k<=70; k++){
                sheet.getRow(k).getCell(2).setCellValue(0);
                sheet.getRow(k).getCell(3).setCellValue(0);
            }
            for (int j = 0; j<carList.size(); j++){
                int data = Integer.parseInt(carList.get(j).getEntrance().substring(8, 10));
                int carCount = Integer.parseInt(carList.get(j).getCount());
                sheet.getRow(39+data).getCell(2).setCellValue(carCount);
            }
            for (int z = 0; z < accesslist.size(); z++){
                int entrance = Integer.parseInt(accesslist.get(z).getEntrance().substring(8,10));
                int count = Integer.parseInt(accesslist.get(z).getCount());
                sheet.getRow(39+entrance).getCell(3).setCellValue(count);
            }

//            FileOutputStream outputStream = new FileOutputStream("C:\\summernote/exam.xls");
//            FileOutputStream outputStream = new FileOutputStream("C:\\");
            workbook.write(response.getOutputStream());
            workbook.close();
//            outputStream.flush();
//            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return  response.getOutputStream();


    }
}
