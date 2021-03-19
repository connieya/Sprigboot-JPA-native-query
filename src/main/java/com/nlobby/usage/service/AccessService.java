package com.nlobby.usage.service;

import com.nlobby.usage.domain.Access;
import com.nlobby.usage.domain.AccessDto;
import com.nlobby.usage.domain.AccessList;
import com.nlobby.usage.repository.AccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessService {

    private final AccessRepository accessRepository;

    public Long 방문인원현황(Date date, Date date2){
       return accessRepository.SearchAccess(date,date2);
    }

    public Long 미방문인원현황(Date date, Date date2){
        return accessRepository.SearchNotAccess(date, date2);
    }

    public Long 방문차량현황(Date date, Date date2){
        return accessRepository.SearchCarAccess(date,date2);
    }

    public Long 미방문차량현황(Date date, Date date2){
        return accessRepository.SearchCarNotAccess(date,date2);
    }
    public String 방문인원최대시간(Date date, Date date2){
        return accessRepository.SearchVisitMax(date,date2);
    }

    public String 방문인원평균시간(Date date, Date date2){
        return accessRepository.SearchVisitAvg(date,date2);
    }

    public String 방문차량최대시간(Date date, Date date2){
        return accessRepository.SearchVisitCarMax(date,date2);
    }

    public String 방문차량평균시간(Date date, Date date2){
        return accessRepository.SearchVisitCarAvg(date,date2);
    }
    public Long 출입인원최대(Date date, Date date2){
        return accessRepository.EntranceMax(date,date2);
    }

    public Long 출입차량최대(Date date, Date date2){
        return accessRepository.EntranceCarMax(date,date2);
    }

    public List<Long> 출입인원평균(Date date, Date date2){
        return accessRepository.EntranceAvg(date,date2);
    }

    public List<Long> 출입차량평균(Date date, Date date2){
        return accessRepository.EntranceCarAvg(date,date2);
    }

    public List<Object[]> 인원일별방문현황(Date date, Date date2){
        System.out.println("sdaddad : " +date);
        System.out.println("sdaddad22 : " +date2);

        return accessRepository.accessList(date, date2);
    }

    public List<AccessDto> 차량일별방문현황(Date date, Date date2){
        return accessRepository.accessCarList(date, date2);
    }

    // 연습코드
    public List<AccessDto> 인원일별방문현황조회(Date date, Date date2){
        return accessRepository.accessGetList(date, date2);
    }

    public List<AccessDto> 차량일별방문현황조회(Date date, Date date2){
        return accessRepository.accessGetCarList(date, date2);
    }



}
