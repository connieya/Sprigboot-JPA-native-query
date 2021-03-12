package com.nlobby.usage.service;

import com.nlobby.usage.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public Long 알림톡갯수(Date date , Date date2){

        return noticeRepository.NoticeCount(date, date2);
    }
}
