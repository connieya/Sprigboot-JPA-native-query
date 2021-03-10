package com.nlobby.usage.web;

import com.nlobby.usage.domain.Member;
import com.nlobby.usage.domain.Privacy;
import com.nlobby.usage.domain.Request;
import com.nlobby.usage.service.NlobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
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

    @GetMapping("/request/{date}")
    public Long 방문객신청현황(@PathVariable Timestamp date){
        return nlobbyService.방문객신청현황(date);
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
