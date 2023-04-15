package org.koreait.models.member;

import org.koreait.controllers.MemberJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class MemberJoinService {
	
	@Autowired
	private MemberDao memberDao;
	
	public void join(MemberJoin memberJoin) {
		// 1. 비밀번호 BCrypt로 해시
		String hash = BCrypt.hashpw(memberJoin.getUserPw(), BCrypt.gensalt(12));
		memberJoin.setUserPw(hash);
		
		// 2. 회원 DB 저장 
		memberDao.insert(memberJoin);
	}
}
