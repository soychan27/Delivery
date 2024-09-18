package com.study.delivery.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class IndexController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return "indexloggedin";
        }
        return "index";
    }

    //Security 테스트
    @GetMapping("/test")
    public @ResponseBody String test() {
        return "권한을 갖고 계십니다.";
    }

    @GetMapping("/myinfo")
    public @ResponseBody String myInfo() {
        return "내 정보";
    }
}
