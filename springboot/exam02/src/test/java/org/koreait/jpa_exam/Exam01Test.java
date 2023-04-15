package org.koreait.jpa_exam;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class Exam01Test {
    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("연습1")
    public void exam01() {
        UserEntity entity = new UserEntity();
        entity.setUserNo(1L);
        entity.setUserId("user01");
        entity.setUserPw("123456");
        entity.setUserNm("사용자01");
        entity.setRegDt(LocalDateTime.now());

        em.persist(entity);     // 상태를 엔티티에 저장 - 영속상태(변화감지)
        em.flush();             // 데이터베이스에 적용

        entity.setUserNm("(수정)사용자01"); // 변화를 감지하여 적용 -> update
//        em.flush();             // 데이터베이스에 적용

        em.detach(entity);      // 영속 상태 분리 - 변화 감지 안됨

        entity.setUserNm("(수정2)사용자01");
        em.flush();

        UserEntity entity2 = em.find(UserEntity.class,1L); // find 시에는 조회 전 자동 flush됨
        System.out.println(entity2);

        em.merge(entity);
        entity.setUserNm("(수정2)사용자01");

        em.flush();

        UserEntity entity3 = em.find(UserEntity.class,1L); // find 시에는 조회 전 자동 flush됨
        System.out.println(entity3);

        em.remove(entity3);
        em.flush();
    }
}
