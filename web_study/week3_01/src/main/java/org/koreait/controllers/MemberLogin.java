package org.koreait.controllers;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MemberLogin {
	@NotBlank(message="아이디를 입력하세요.")
	@Size(min=6, message="아이디는 6자리 이상 입력하세요.")
	private String userId;
	
	@NotBlank(message="비밀번호를 입력하세요.")
	@Size(min=8, max=18, message="비밀번호는 8자리 이상 18이하 입력하세요.")
	private String userPw;
	private boolean saveId;
	
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
	
	public boolean isSaveId() {
		return saveId;
	}
	
	public void setSaveId(boolean saveId) {
		this.saveId = saveId;
	}

	@Override
	public String toString() {
		return "MemberLogin [userId=" + userId + ", userPw=" + userPw + ", saveId=" + saveId + "]";
	}
}
