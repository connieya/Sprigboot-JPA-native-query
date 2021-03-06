package com.nlobby.usage.web;

import com.nlobby.usage.domain.*;
import com.nlobby.usage.service.NlobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NlobbyController {

    private final NlobbyService nlobbyService;
    private final RequestController requestController;

    @GetMapping("/")
    public String  hello(){

        return "hello";

    }
    @GetMapping("/request")
    public List<Request> 신청현황조회(){
        return nlobbyService.신청현황조회();
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

    @GetMapping("/access")
    public List<Access> 방문현황조회(){
        return nlobbyService.방문현황조회();
    }


    @GetMapping("/date/{date}")
    public String 날짜변환(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        DateData.getMonth(date);
        DateData.getMonth2(date);


        return DateData.serialization(date);

    }
}
