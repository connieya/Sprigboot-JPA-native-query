package com.nlobby.usage.web;

import com.nlobby.usage.domain.Request;
import com.nlobby.usage.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;


    //방문객 신청현황
    @CrossOrigin
    @GetMapping("/request/regist/{date}")
    public Long 방문객신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        System.out.println("Date !!! : " +date);

        Calendar calendar = Calendar.getInstance();
        Calendar  calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar2.set(Calendar.HOUR_OF_DAY,0);
        calendar2.add(Calendar.MONTH,1);
        return requestService.방문객신청현황(calendar.getTime(), calendar2.getTime());

    }
    @CrossOrigin
    @GetMapping("/request/reserve/{date}")
    public Long 임직원신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);


        return requestService.임직원신청현황(c.getTime(), c2.getTime());

    }
    @CrossOrigin
    @GetMapping("/request/registCar/{date}")
    public Long 방문객차량신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.add(Calendar.MONTH, 1);


        return requestService.방문객차량신청현황(c.getTime(), c2.getTime());
    }
    @CrossOrigin
    @GetMapping("/request/reserveCar/{date}")
    public Long 임직원차량신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.add(Calendar.MONTH, 1);


        return requestService.임직원차량신청현황(c.getTime(), c2.getTime());
    }

    @CrossOrigin
    @GetMapping("/request/example/{date}")
    public Long  테스트코드(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.add(Calendar.MONTH, 1);

        return requestService.테스트코드(c.getTime(),c2.getTime());
    }

}
