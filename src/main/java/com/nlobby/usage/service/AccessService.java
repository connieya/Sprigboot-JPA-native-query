package com.nlobby.usage.service;

import com.nlobby.usage.domain.Access;
import com.nlobby.usage.repository.AccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessService {

    private final AccessRepository accessRepository;

    public List<Access> 방문현황데이터조회하기(String datas){
        return accessRepository.SearchAccessDatas(datas);
    }
}
