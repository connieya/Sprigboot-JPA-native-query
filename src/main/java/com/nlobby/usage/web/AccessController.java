package com.nlobby.usage.web;


import com.nlobby.usage.domain.Access;
import com.nlobby.usage.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccessController {

    private final AccessService accessService;

    @GetMapping("/access/datas")
    public List<Access> 방문현황데이터조회하기(String datas){

        return accessService.방문현황데이터조회하기(datas);
    }
}
