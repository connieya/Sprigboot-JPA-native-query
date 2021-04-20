package com.nlobby.usage.web;

import com.nlobby.usage.domain.DateData;
import com.nlobby.usage.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;


    //방문객 신청현황
    @CrossOrigin
    @GetMapping("/request/regist/{date}")
    public Long 방문객신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        return requestService.방문객신청현황(DateData.getMonth(date), DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/request/reserve/{date}")
    public Long 임직원신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        return requestService.임직원신청현황(DateData.getMonth(date), DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/request/registCar/{date}")
    public Long 방문객차량신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {

        return requestService.방문객차량신청현황(DateData.getMonth(date), DateData.getMonth2(date));
    }
    @CrossOrigin
    @GetMapping("/request/reserveCar/{date}")
    public Long 임직원차량신청현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {


        return requestService.임직원차량신청현황(DateData.getMonth(date), DateData.getMonth2(date));
    }

    @CrossOrigin
    @GetMapping("/request/example/{date}")
    public Long  테스트코드(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        return requestService.테스트코드(DateData.getMonth(date),DateData.getMonth2(date));
    }

}
