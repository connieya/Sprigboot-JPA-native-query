package com.nlobby.usage.web;

import com.nlobby.usage.domain.Member;
import com.nlobby.usage.domain.Privacy;
import com.nlobby.usage.domain.Request;
import com.nlobby.usage.service.NlobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NlobbyController {

    private final NlobbyService nlobbyService;

    @GetMapping("/")
    public String  hello(){

        return "hello";

    }

    @GetMapping("/request")
    public List<Request> findAll(){
        return nlobbyService.신청현황조회();
    }

    //방문객 신청현황
    @GetMapping("/request/regist/{date}")
    public Long 방문객신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        System.out.println("Date !!! : " +date);

        Calendar  calendar = Calendar.getInstance();
        Calendar  calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar2.set(Calendar.HOUR_OF_DAY,0);
        calendar2.add(Calendar.MONTH,1);
        return nlobbyService.방문객신청현황(calendar.getTime(), calendar2.getTime());

    }
    @GetMapping("/request/reserve/{date}")
    public Long 임직원신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);


        return nlobbyService.임직원신청현황(c.getTime(), c2.getTime());

    }

    @GetMapping("/request/name/{name}")
    public List<Request> 이름으로신청현황조회(@PathVariable String name){
        System.out.println("controller 이름!!!! : "+name);
        return nlobbyService.이름으로신청현황조회(name);
    }

    @GetMapping("/member")
    public List<Member> findMembers(){

        return nlobbyService.멤버조회();
    }

    @GetMapping("/privacy")
    public List<Privacy> findPrivacies(){
        return nlobbyService.프라이버시조회();
    }
}
