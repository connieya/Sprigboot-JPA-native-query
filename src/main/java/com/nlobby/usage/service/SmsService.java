package com.nlobby.usage.service;

import com.nlobby.usage.repository.NoticeRepository;
import com.nlobby.usage.repository.SMSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final SMSRepository smsRepository;

    public Long SMS갯수(Date date , Date date2){

        return smsRepository.SMSCount(date, date2);
    }
}
