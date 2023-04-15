package org.koreait.controllers;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MemberJoin {
	@Size(min=6, message="아이디는 6자리 이상 입력하세요.")
	@NotBlank(message="아이디를 입력하세요.")
	private String userId;
	
	@Size(min=8, message="비밀번호는 8자리 이상 입력하세요.")
	@NotBlank(message="비밀번호를 입력하세요.")
	private String userPw;
	
	@NotBlank(message="비밀번호를 확인하세요.")
	private String  userPwRe;
	
	@NotBlank(message="회원명을 입력하세요.")
	private String userNm;
	
	@AssertTrue(message="약관에 동의하세요.")
	private boolean agree;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserNm() {
		return userNm;
	}
	
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserPwRe() {
		return userPwRe;
	}

	public void setUserPwRe(String userPwRe) {
		this.userPwRe = userPwRe;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "MemberJoin [userId=" + userId + ", userPw=" + userPw + ", userPwRe=" + userPwRe + ", userNm=" + userNm
				+ ", agree=" + agree + "]";
	}
}
