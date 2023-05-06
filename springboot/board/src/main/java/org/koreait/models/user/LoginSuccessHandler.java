package org.koreait.models.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.removeAttribute("requiredUserId");
        session.removeAttribute("requiredUserPw");
        session.removeAttribute("loginFail");
        session.removeAttribute("userId");
        
        String saveId = request.getParameter("saveId");
        String userId = request.getParameter("userId");
        Cookie cookie = new Cookie("saveId",userId);
        if (saveId == null) {   // saveId 쿠키 삭제
            cookie.setMaxAge(0);
        }else { // saveId 쿠키 등록
            cookie.setMaxAge(60*60*24*365);
        }
        
        response.addCookie(cookie); // 응답헤더에 쿠키 추가

        /** 로그인 회원 정보 세션 저장 */
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        session.setAttribute("userInfo", userInfo);



        response.sendRedirect(request.getContextPath());

    }
}
