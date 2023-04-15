package org.koreait.exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		// mysql에 데이터 추가하기
		
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		
		Member member = new Member();
		member.setUserId("user03");
		member.setUserNm("사용자03");
		member.setUserPw("123456");
		member.setEmail("user03@test.org");
		member.setMobile("01000000000");
		
		boolean result = memberDao.insert(member);
		System.out.print(result);
		ctx.close();
	}

}
