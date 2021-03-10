package com.nlobby.usage.service;

import com.nlobby.usage.domain.Access;
import com.nlobby.usage.domain.Member;
import com.nlobby.usage.domain.Privacy;
import com.nlobby.usage.domain.Request;
import com.nlobby.usage.repository.AccessRepository;
import com.nlobby.usage.repository.MemberRepository;
import com.nlobby.usage.repository.PrivacyRepository;
import com.nlobby.usage.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NlobbyService {

    private final RequestRepository requestRepository;
    private final MemberRepository memberRepository;
    private final PrivacyRepository privacyRepository;
    private final AccessRepository accessRepository;


    public List<Request> 신청현황조회(){

        return requestRepository.findAll();
    }

    public List<Access> 방문현황조회(){
        return accessRepository.findAll();
    }

    public List<Member> 멤버조회(){

        return memberRepository.findAll();

    }

    public List<Request> 이름으로신청현황조회(String name){
        return requestRepository.SearchRequestByName(name);
    }

    public List<Privacy> 프라이버시조회(){
        return privacyRepository.findAll();
    }

}
