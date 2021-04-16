package com.nlobby.usage.service;

import com.nlobby.usage.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostService {

    private final HostRepository hostRepository;

    public Long 사용자수(){
       return hostRepository.UserCount();
    }




}
