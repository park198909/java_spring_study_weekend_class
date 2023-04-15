package org.koreait.controllers;

import org.koreait.models.member.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody   // 해당 메서드를 Rest형태로 응답(JSON 자동응답)
    @GetMapping("/user2")
    public UserInfo userInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNo(1L);
        userInfo.setUserId("user01");
        userInfo.setUserPw("123456");
        userInfo.setUserNm("사용자01");
        userInfo.setRegDt(LocalDateTime.now());

        return userInfo;
    }
}
