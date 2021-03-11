package com.nlobby.usage.service;

import com.nlobby.usage.domain.Access;
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


}
