package org.koreait.controllers.mypage;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.apache.catalina.User;
import org.koreait.entities.BoardData;
import org.koreait.models.user.UserInfo;
import org.koreait.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Log
@Controller("mypageMainController")
public class MainController {

    @Autowired
    private BoardDataRepository repository;

    //@ResponseBody
    @GetMapping("/mypage")
    public String index() {

        return "mypage/index";
    }
    /**
    public void index() {
        BoardData boardData = BoardData.builder()
                .subject("제목!!!!")
                .content("내용!!!!")
                .boardId("notice")
                .build();

        boardData = repository.saveAndFlush(boardData);
        boardData.setSubject("(수정)제목!!!!");
        repository.flush();
    }
     */
    /**
    public void index(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if(userInfo != null) {
            log.info(userInfo.toString());
        }
    }
     */
    /**
    public void index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserInfo) {
            UserInfo userInfo = (UserInfo)auth.getPrincipal();
            log.info(userInfo.toString());
        }
    }
     */
    /**
    public void index(@AuthenticationPrincipal UserInfo userInfo){  // 로그인한 유저정보 객체 생성
        log.info(userInfo.toString());  // 로그인한 유저정보 출력
    }
     */
    /**
    public void index(Principal principal) {
        String userId = principal.getName();
        log.info(userId);
    }
     */
}
