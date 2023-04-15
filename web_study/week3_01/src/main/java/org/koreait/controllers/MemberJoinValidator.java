package org.koreait.controllers;

import org.koreait.models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MemberJoinValidator implements Validator {
	
	private MemberDao memberDao;
	
	@Autowired
	private void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberJoin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberJoin memberJoin = (MemberJoin)target;
		String userId = memberJoin.getUserId();
		String userPw = memberJoin.getUserPw();
		String userPwRe = memberJoin.getUserPwRe();
		
		// 1. 아이디 중복 여부 체크 
		if (userId != null && !userId.isBlank()) {
			boolean isDup = memberDao.isExists(userId);
			if (isDup) {
				errors.rejectValue("userId", "DuplicatedUserId", "이미 가입된 아이디 입니다.");
			}
		}
		
		// 2. 비밀번호, 비밀번호 확인 일치 여부(userPw, userPwRe)
		if (userPw != null && !userPw.isBlank() 
				&& userPwRe != null && !userPwRe.isBlank() && !userPw.equals(userPwRe)) {
			errors.rejectValue("userPwRe", "Incorrect Password", "비밀번호가 일치하지 않습니다.");
		}
	}
}
