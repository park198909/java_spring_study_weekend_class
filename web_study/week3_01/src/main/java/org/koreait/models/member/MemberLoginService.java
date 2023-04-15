package org.koreait.models.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.koreait.controllers.MemberLogin;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {
	
	private MemberDao memberDao;
	private HttpSession session;
	private HttpServletResponse response;
	
	public MemberLoginService(MemberDao memberDao, HttpSession session, HttpServletResponse response) {
		this.memberDao = memberDao;
		this.session = session;
		this.response = response;
	}
	
	public void login(MemberLogin memberLogin) {
		// 1. 회원 조회
		Member member = memberDao.get(memberLogin.getUserId());
		if (member == null) {
			throw new RuntimeException("조회된 회원이 없습니다.");
		}
		
		// 2. 로그인 세션 처리
		session.setAttribute("member", member);
		
		// 3. 아이디 저장
		Cookie cookie = new Cookie("saveId", member.getUserId());
		if (memberLogin.isSaveId()) { // 아이디 저장을 체크한 경우 - 저장
			cookie.setMaxAge(60 * 60 * 24 * 365); 
		} else { // 아이디 저장을 체크 X -> 삭제 
			cookie.setMaxAge(0);
		}
		
		response.addCookie(cookie);
	}
}
