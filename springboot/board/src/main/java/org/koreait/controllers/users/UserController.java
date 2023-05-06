package org.koreait.controllers.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.mapping.Join;
import org.koreait.models.user.UserJoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserJoinService joinService;

    @GetMapping("/login")
    public String login(@CookieValue(required = false) String saveId, Model model) {
        if(saveId != null){
            model.addAttribute("saveId",saveId);
        }
        return "user/login";
    }

    @ResponseBody
    @GetMapping("/join")
    public void join() {
        JoinForm joinForm = JoinForm.builder()
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .mobile("01000000000")
                .build();

        joinService.join(joinForm);
    }
}
