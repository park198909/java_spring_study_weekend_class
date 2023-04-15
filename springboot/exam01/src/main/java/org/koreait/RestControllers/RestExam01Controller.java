package org.koreait.RestControllers;

import org.koreait.models.member.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestExam01Controller {
    @GetMapping("/ex01")
    public Member ex01(){
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userNm("사용자01")
                .userPw("1234567")
                .regDt(LocalDateTime.now())
                .build();

        return member;
    }

    @GetMapping("/ex02")
    public List<Member> ex02(){
        List<Member> members = new ArrayList<>();

        for(int i=1; i<10; i++){
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userId("user"+i)
                    .userNm("사용자"+i)
                    .userPw("1234567")
                    .build();

            members.add(member);
        }

        return members;
    }
}
