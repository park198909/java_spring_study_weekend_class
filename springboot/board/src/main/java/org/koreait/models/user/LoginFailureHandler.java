package org.koreait.models.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        session.removeAttribute("requiredUserId");
        session.removeAttribute("requiredUserPw");
        session.removeAttribute("loginFail");

        if (userId == null || userId.isBlank()) {
            session.setAttribute("requiredUserId", "아이디를 입력하세요.");
        }

        if (userPw == null || userPw.isBlank()) {
            session.setAttribute("requiredUserPw", "비밀번호를 입력하세요.");
        }

        if (userId != null && userPw != null && !userId.isBlank() && !userPw.isBlank()) { // 아이디, 비밀번호 인증 실패
            session.setAttribute("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
        }

        session.setAttribute("userId", userId);

        String url = request.getContextPath() + "/user/login";
        response.sendRedirect(url);
    }
}
