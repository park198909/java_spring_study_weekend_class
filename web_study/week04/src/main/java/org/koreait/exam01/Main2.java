package org.koreait.exam01;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		// mysql에 데이터 추가하기
		
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		
//		Member member = memberDao.get("user05");
//		System.out.println(member);
		
		/*
		//전체멤버 조회
		List<Member> members = memberDao.gets();
		
		for(Member member : members) {
			System.out.println(member);
		}
		*/
		
		// 멤버 삭제
		boolean result = memberDao.delete("user01");
		System.out.println(result);
		
		ctx.close();
	}

}
