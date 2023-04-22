package org.koreait.restControllers.exam;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.koreait.entities.Users;
import org.koreait.repositories.PostDataRepository;
import org.koreait.repositories.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import static org.springframework.data.domain.Sort.Order.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Log
@RestController
@RequestMapping("/jpa/exam01")
@RequiredArgsConstructor
public class JPAExam01Controller {

    private final UsersRepository usersRepository;
    private final PostDataRepository postDataRepository;

    @GetMapping("/ex01")
    public void ex01() {
        Users user = new Users();
        user.setUserId("user01");
        user.setUserPw("123456");
        user.setUserNm("사용자01");
        user.setEmail("user01@test.org");
        user.setMobile("01000000000");

        Users user2 = usersRepository.saveAndFlush(user);   // 영속성 상태
        log.info(user2.toString());     // System.out.println() 대체가능

        user2.setUserNm("(수정)사용자01");
        usersRepository.flush();

        usersRepository.delete(user2);
        usersRepository.flush();
    }

    @GetMapping("/ex02")
    public void ex02() {
        List<Users> users = new ArrayList<>();
        for(int i=12; i<=20; i++) {
            Users user = new Users();
            user.setUserId("user" + i);
            user.setUserPw("123456");
            user.setUserNm("사용자" + i);
            user.setEmail("user" + i + "@test.org");
            user.setMobile("01000000000");

            users.add(user);
        }

        List<Users> users2 = usersRepository.saveAllAndFlush(users);
        for(Users user : users2) {
            user.setUserNm("(수정)"+user.getUserNm());
        }
        usersRepository.flush();
    }

    @GetMapping("/ex03")
    public void ex03() {
        Users user = usersRepository.findById(3L).orElse(null);
        log.info(user.toString());
    }

    @GetMapping("/ex04")
    public void ex04() {
//        List<Users> users = usersRepository.findAll();      // 전체조회
//        List<Users> users = usersRepository.findAll(Sort.by(desc("regDt"), asc("userId")));
        Pageable pageable = PageRequest.of(1,3,Sort.by(desc("regDt"))); // 3개씩 2페이지
        Page<Users> page = usersRepository.findAll(pageable);   // 페이지 조회 후 반환
        List<Users> users = page.getContent();                  // 페이지 내용  List로 가져오기
        for(Users user : users) {
            log.info(user.toString());
        }
    }

    @GetMapping("/ex05")
    public void ex05() {
        Users user = usersRepository.findByUserId("user2");
        log.info(user.toString());
    }
}
