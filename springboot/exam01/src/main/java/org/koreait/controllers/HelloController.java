package org.koreait.controllers;

import org.koreait.models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
//        Member member = new Member();   // @Builder -> private 생성자(){}
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .build();
        System.out.println(member);
        member.info();
//        Member member = new Member("user01","123456");
//        Member member = new Member(1L,"user01","123456", "사용자01");
//        System.out.println(member);
//        member.setUserId("user01");
//        member.setUserPw("123456");
//        member.setUserNm("사용자01");

        return "hello";
    }
}
