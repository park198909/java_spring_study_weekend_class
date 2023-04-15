package org.koreait.exam01;

import java.time.LocalDateTime;

public class Member {
	private long userNo;
	private String userId;
	private String userPw;
	private String userNm;
	private String email;
	private String mobile;
	private LocalDateTime regDt;
	
	// 게터 와 세터 생성
	public long getUserNo() {
		return userNo;
	}
	
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public LocalDateTime getRegDt() {
		return regDt;
	}
	
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm
				+ ", email=" + email + ", mobile=" + mobile + ", regDt=" + regDt + "]";
	}
	
	
}
