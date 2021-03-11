package com.nlobby.usage.web;


import com.nlobby.usage.domain.Access;
import com.nlobby.usage.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccessController {

    private final AccessService accessService;

    @GetMapping("/access/visit/{date}")
    public Long 방문인원현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.방문인원현황(c.getTime(),c2.getTime());

    }
    @GetMapping("/access/visitNot/{date}")
    public Long 미방문인원현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.미방문인원현황(c.getTime(),c2.getTime());

    }

    @GetMapping("/access/visitCar/{date}")
    public Long 방문차량현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.방문차량현황(c.getTime(),c2.getTime());

    }
    @GetMapping("/access/visitNotCar/{date}")
    public Long 미방문차량현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.미방문차량현황(c.getTime(),c2.getTime());

    }
    @GetMapping("/access/visitMaxTime/{date}")
    public String 방문인원최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.방문인원최대시간(c.getTime(),c2.getTime());

    }

    @GetMapping("/access/visitAvgTime/{date}")
    public String 방문인원평균시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.방문인원평균시간(c.getTime(),c2.getTime());

    }
}
