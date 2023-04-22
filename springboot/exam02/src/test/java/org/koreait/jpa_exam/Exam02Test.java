package org.koreait.jpa_exam;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class Exam02Test {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("JPA 엔티티 연습1")
    public void ex01(){
        // persist -> 엔티티 -> 영속성 컨택스트(메모리) : 영속성관리 가능 상태
        // 상태감지
        Users user = new Users();
        user.setUserNo(1L);
        user.setUserId("user01");
        user.setUserPw("123456");
        user.setUserNm("사용자01");
        user.setEmail("user01@test.org");
        user.setMobile("01000000000");

        em.persist(user);   // 영속성 컨택스트(Persistence Context) : 엔티티의 상태 감지(managed)
                            // 없는 엔티티 -> 추가(INSERT), 있으면 : 수정(UPDATE)
        em.flush();

        em.detach(user);    // 영속성 분리 : 상태변화 감지 X

        user.setUserNm("(수정)사용자01");

        em.merge(user);     // 분리된 영속성을 영속성에 포함시킴

        Users user2 = em.find(Users.class, 1L); // flush()후에 find()실행
        System.out.println(user2);


//        em.flush();

//        em.remove(user);    // 엔티티 상태 -> 제거 상태(remove)
//        em.flush();
    }
}
