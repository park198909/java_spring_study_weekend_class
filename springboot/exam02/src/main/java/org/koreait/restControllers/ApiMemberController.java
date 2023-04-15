package org.koreait.restControllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.java.Log;
import org.koreait.commons.CommonException;
import org.koreait.commons.JSONResult;
import org.koreait.models.member.UserInfo;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log    // Log를 추가
@RestController
@RequestMapping("/api")
public class ApiMemberController {
    @GetMapping("/user")
    public UserInfo usreInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNo(1L);
        userInfo.setUserId("user01");
        userInfo.setUserPw("123456");
        userInfo.setUserNm("사용자01");
        userInfo.setRegDt(LocalDateTime.now());

        boolean result = false;
        if(!result){
            throw new CommonException("예외 발생!!!", HttpStatus.BAD_REQUEST);
        }

        return userInfo;
    }

    @GetMapping("/users")
    public List<UserInfo> userInfos() {
        List<UserInfo> users = new ArrayList<>();
        for(int i=1; i<=10; i++){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserNo(Long.valueOf(i));
            userInfo.setUserId("user"+i);
            userInfo.setUserPw("123456");
            userInfo.setUserNm("사용자"+i);
            userInfo.setRegDt(LocalDateTime.now());
            users.add(userInfo);
        }
        return users;
    }

    @GetMapping("/test_string")
    public String testString(){
        return "테스트!!";
    }

    @GetMapping("/test_void")
    public void testVoid() {}

    @PostMapping("/test/rest1")
    public void testRestData(@RequestBody UserInfo userInfo) {
        log.info(userInfo.toString());
    }

    @PostMapping("/test/rest2")
    public ResponseEntity<UserInfo> testRestData2(@RequestBody UserInfo userInfo){

//        return ResponseEntity.status(HttpStatus.CREATED)
//                            .body(userInfo);

//        return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.created(URI.create("/hello")).build();
    }


}
