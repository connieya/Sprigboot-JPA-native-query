package com.nlobby.usage.web;


import com.nlobby.usage.domain.Access;
import com.nlobby.usage.domain.AccessDto;
import com.nlobby.usage.domain.AccessList;
import com.nlobby.usage.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin
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
    @CrossOrigin
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
    @CrossOrigin
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
    @CrossOrigin
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
    @CrossOrigin
    @GetMapping("/access/visitMaxTime/{date}")
    public String 방문인원최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.add(Calendar.MONTH, 1);

        String data = accessService.방문인원최대시간(c.getTime(), c2.getTime());
        try {
            StringBuilder data2 = new StringBuilder(data);
            StringBuilder data3 = data2.insert(2, '일');
            data3.setCharAt(6, '시');
            data3.setCharAt(9, '분');
            data3.delete(10, 12);
            return data3.toString();
//            return data;

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }



    @CrossOrigin
    @GetMapping("/access/visitAvgTime/{date}")
    public String 방문인원평균시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        String data = accessService.방문인원평균시간(c.getTime(),c2.getTime());


        try {
            StringBuilder data2 = new StringBuilder(data);
            StringBuilder data3 = data2.insert(2, '일');
            data3.setCharAt(6, '시');
            data3.setCharAt(9, '분');
            data3.delete(10, 12);
            return data3.toString();

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }
    @CrossOrigin
    @GetMapping("/access/visitCarMaxTime/{date}")
    public String 방문차량최대시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        String data = accessService.방문차량최대시간(c.getTime(),c2.getTime());

        try {
            StringBuilder data2 = new StringBuilder(data);
            StringBuilder data3 = data2.insert(2, '일');
            data3.setCharAt(6, '시');
            data3.setCharAt(9, '분');
            data3.delete(10, 12);
            return data3.toString();

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }
    @CrossOrigin
    @GetMapping("/access/visitCarAvgTime/{date}")
    public String 방문차량평균시간(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        String data = accessService.방문차량평균시간(c.getTime(),c2.getTime());

        try {
            StringBuilder data2 = new StringBuilder(data);
            StringBuilder data3 = data2.insert(2, '일');
            data3.setCharAt(6, '시');
            data3.setCharAt(9, '분');
            data3.delete(10, 12);
            return data3.toString();

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }
    @CrossOrigin
    @GetMapping("/access/entranceMax/{date}")
    public Long 출입인원최대(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.출입인원최대(c.getTime(),c2.getTime());

    }
    @CrossOrigin
    @GetMapping("/access/entranceCarMax/{date}")
    public Long 출입차량최대(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.출입차량최대(c.getTime(),c2.getTime());

    }
    @CrossOrigin
    @GetMapping("/access/entranceAvg/{date}")
    public Long 출입인원평균(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        try {
            return accessService.출입인원평균(c.getTime(),c2.getTime());
        }catch (Exception e){

        }



        return null;

    }
    @CrossOrigin
    @GetMapping("/access/entranceCarAvg/{date}")
    public Long 출입차량평균(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        try {
            return accessService.출입차량평균(c.getTime(),c2.getTime());
        }catch (Exception e){

        }



        return null;

    }

    @CrossOrigin
    @GetMapping("/access/list/{date}")
    public List<Object[]> 인원일별방문현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);


        return accessService.인원일별방문현황(c.getTime(),c2.getTime());
//        return c2.getTime();

    }
    @CrossOrigin
    @GetMapping("/access/getList/{date}")
    public List<AccessDto> 인원일별방문현황조회(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.인원일별방문현황조회(c.getTime(),c2.getTime());

    }
    @CrossOrigin
    @GetMapping("/access/getCarList/{date}")
    public List<AccessDto> 차량일별방문현황조회(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.차량일별방문현황조회(c.getTime(),c2.getTime());

    }

    @CrossOrigin
    @GetMapping("/access/carList/{date}")
    public List<AccessDto> 차량일별방문현황(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY,0);
        c2.add(Calendar.MONTH,1);

        return accessService.차량일별방문현황(c.getTime(),c2.getTime());

    }
}
