package com.nlobby.usage.web;

import com.nlobby.usage.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @CrossOrigin
    @GetMapping("/notice/{date}")
    public Long 알림톡갯수(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        Calendar calendar = Calendar.getInstance();
        Calendar  calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar2.set(Calendar.HOUR_OF_DAY,0);
        calendar2.add(Calendar.MONTH,1);

        return noticeService.알림톡갯수(calendar.getTime(), calendar2.getTime());
    }

}
