package com.nlobby.usage.web;


import com.nlobby.usage.domain.AccessDto;
import com.nlobby.usage.domain.DateData;
import com.nlobby.usage.domain.IntervalDto;
import com.nlobby.usage.domain.StringFormatting;
import com.nlobby.usage.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.Duration;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccessController {

    private final AccessService accessService;

    @CrossOrigin
    @GetMapping("/access/visit/{date}")
    public Long 방문인원현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        return accessService.방문인원현황(DateData.getMonth(date),DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/access/visitNot/{date}")
    public Long 미방문인원현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        return accessService.미방문인원현황(DateData.getMonth(date),DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/access/visitCar/{date}")
    public Long 방문차량현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        return accessService.방문차량현황(DateData.getMonth(date),DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/access/visitNotCar/{date}")
    public Long 미방문차량현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        return accessService.미방문차량현황(DateData.getMonth(date),DateData.getMonth2(date));

    }

    @CrossOrigin
    @GetMapping("/access/visitMaxTime/{date}")
    public String 방문인원최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {


        String data = accessService.방문인원최대시간(DateData.getMonth(date),DateData.getMonth2(date));
        return StringFormatting.문자열변환(data);

    }

    @CrossOrigin
    @GetMapping("/access/visitMaxTime2/{date}")
    public Period 방문인원최대시간2(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        return accessService.방문인원최대시간2(DateData.getMonth(date),DateData.getMonth2(date));
    }

    @CrossOrigin
    @GetMapping("/access/visitAvgTime/{date}")
    public String 방문인원평균시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        String data =
                accessService.방문인원평균시간(DateData.getMonth(date),DateData.getMonth2(date));

        return StringFormatting.문자열변환(data);


    }
    @CrossOrigin
    @GetMapping("/access/visitCarMaxTime/{date}")
    public String 방문차량최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        String data =
                accessService.방문차량최대시간(DateData.getMonth(date),DateData.getMonth2(date));

        return StringFormatting.문자열변환(data);
    }
    @CrossOrigin
    @GetMapping("/access/visitCarAvgTime/{date}")
    public String 방문차량평균시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        String data =
                accessService.방문차량평균시간(DateData.getMonth(date), DateData.getMonth2(date));

        return StringFormatting.문자열변환(data);

    }
    @CrossOrigin
    @GetMapping("/access/entranceMax/{date}")
    public Long 출입인원최대(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){



        return accessService.출입인원최대(DateData.getMonth(date),DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/access/entranceCarMax/{date}")
    public Long 출입차량최대(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        return accessService.출입차량최대(DateData.getMonth(date),DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/access/entranceAvg/{date}")
    public Long 출입인원평균(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){




            return accessService.출입인원평균(DateData.getMonth(date),DateData.getMonth2(date));


    }
    @CrossOrigin
    @GetMapping("/access/entranceCarAvg/{date}")
    public Long 출입차량평균(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

            return accessService.출입차량평균(DateData.getMonth(date),DateData.getMonth2(date));
    }
    @CrossOrigin
    @GetMapping("/access/getList/{date}")
    public List<AccessDto> 인원일별방문현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        return accessService.인원일별방문현황(DateData.getMonth(date),DateData.getMonth2(date));

    }
    @CrossOrigin
    @GetMapping("/access/count/{date}")
    public int[] 일별인원수(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int entranceCount[] = new int[actualMaximum];

        List<AccessDto> result = accessService.인원일별방문현황(DateData.getMonth(date),DateData.getMonth2(date));
        for (int i=0; i<result.size(); i++){
            int arrayValue =
                    Integer.parseInt(result.get(i).getEntrance().substring(8,10));

            entranceCount[arrayValue-1] = Integer.parseInt(result.get(i).getCount());
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  entranceCount;
    }
    @CrossOrigin
    @GetMapping("/access/lastDate/{date}")
    public int[] 마지막날짜(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int accessDate[] = new int[actualMaximum];

        for (int i=0; i<accessDate.length; i++){
            accessDate[i] = i+1;
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accessDate;
    }


    @CrossOrigin
    @GetMapping("/access/visitCarCount/{date}")
    public int[] 일별차량방문수(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int actualMaximum2 = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int entranceCarCount [] = new int[actualMaximum2];

        List<AccessDto> result2 = accessService.차량일별방문현황(DateData.getMonth(date),DateData.getMonth2(date));
        for (int i=0; i<result2.size(); i++){
            int arrayValue =
                    Integer.parseInt(result2.get(i).getEntrance().substring(8,10));

            entranceCarCount[arrayValue-1] = Integer.parseInt(result2.get(i).getCount());
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  entranceCarCount;

    }



    @CrossOrigin
    @GetMapping("/access/carList/{date}")
    public List<AccessDto> 차량일별방문현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){


        return accessService.차량일별방문현황(DateData.getMonth(date),DateData.getMonth2(date));


    }
}
