package com.nlobby.usage.service;

import com.nlobby.usage.domain.Request;
import com.nlobby.usage.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public Long 방문객신청현황(Date date, Date date2){
        return requestRepository.SearchRequest(date ,date2);
    }

    public Long 임직원신청현황(Date date, Date date2){
        return requestRepository.SearchRequestReserve(date,date2);
    }
    public Long 방문객차량신청현황(Date date, Date date2){
        return requestRepository.SearchRequestCar(date,date2);
    }

    public Long 임직원차량신청현황(Date date, Date date2){
        System.out.println("date : "+date);
        System.out.println("date2 : "+date2);
        return requestRepository.SearchRequestCarReserve(date,date2);
    }

    public Long 테스트코드(Date date, Date date2){

        return requestRepository.requestExample(date, date2);
    }



}
