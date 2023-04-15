package org.koreait.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLogoutController {
	
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 비우기
		
		return "redirect:/member/login"; // 로그아웃 -> 로그인 페이지 이동
	}
}

