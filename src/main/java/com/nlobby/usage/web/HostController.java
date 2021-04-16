package com.nlobby.usage.web;

import com.nlobby.usage.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HostController {

    private final HostService hostService;

    @CrossOrigin
    @GetMapping("/nlobby/user")
    public Long 사용자수(){

        return hostService.사용자수();
    }

}
