package org.koreait.tests;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.*;
import org.koreait.repositories.AddressRepository;
import org.koreait.repositories.BoardDataRepository;
import org.koreait.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class JpaExam01Test {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EntityManager em;

    @BeforeEach
    void insertData() {
        Address address = Address.builder()
                .addr1("주소1")
                .addr2("주소2")
                .zipcode("0000")
                .build();
        address = addressRepository.saveAndFlush(address);

        Users user = Users.builder()
                .userId("user01")
                .userNm("사용자01")
                .userPw("123456")
                .email("user01@test.org")
                .mobile("01000000000")
                .address(address)
                .build();
        user = usersRepository.saveAndFlush(user);  // 영속성 추가 및 상태변화 감지

        List<BoardData> items = new ArrayList<>();
        for(int i=1; i<=10; i++) {
            BoardData item = BoardData.builder()
                    .boardId("notice")
                    .subject("제목"+i)
                    .content("내용"+i)
                    .user(user)
                    .build();
            items.add(item);
        }

        items = boardDataRepository.saveAllAndFlush(items);
        for(BoardData item : items) {
            em.detach(item);
        }

        em.detach(user);
    }

    @Test
    @DisplayName("관계 매핑 연습1")
    void ex01() {
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        Users user = data.getUser();
        String userId = user.getUserId();
        System.out.println("userId="+userId);
//        System.out.println(data);
//        Users user = data.getUser();
//        System.out.println(user);
    }

    @Test
    @DisplayName("관계 매핑 연습2")
    void ex02() {
        Users user = usersRepository.findById(1L).orElse(null);
        List<BoardData> items = user.getBoardDatas();
        for(BoardData item : items) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("관계 매핑 연습3")
    void ex03() {   // N+1문제
        List<BoardData> items = boardDataRepository.findByBoardId("notice");

        for(BoardData item : items) {
            Users user = item.getUser();
            String userId = user.getUserId();
            System.out.printf("userId=%s%n",userId);
        }
    }

    @Test
    @DisplayName("관계 매핑 연습4")
    void ex04() {
        List<BoardData> items = boardDataRepository.getBoardDatas("notice");    // 관계데이터 조회
    }

    @Test
    @DisplayName("관계 매핑 연습5")
    void ex05() {
        QBoardData boardData = QBoardData.boardData;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        JPAQuery<BoardData> jpaQuery = jpaQueryFactory.selectFrom(boardData)
                .leftJoin(boardData.user)
                .where(boardData.boardId.eq("notice"))
                .fetchJoin();

        List<BoardData> items = jpaQuery.fetch();
        for(BoardData item : items) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("관계 매핑 연습6")
    void ex06() {
        Users user = usersRepository.findById(1L).orElse(null);
        Address address = user.getAddress();
        System.out.printf("addr1=%s, addr2=%s%n",address.getAddr1(),address.getAddr2());
    }

    @Test
    @DisplayName("관계 매핑 연습7")
    void ex07() {
       Address address = Address.builder()
               .addr1("주소1")
               .addr2("주소2")
               .zipcode("0000")
               .build();
       address = addressRepository.saveAndFlush(address);

       Users user = usersRepository.findById(1L).orElse(null);
       user.setAddress(address);
       usersRepository.flush();

//       em.detach(address);
//       System.out.println(address);
       address=addressRepository.findById(address.getId()).orElse(null);
       address.getUser().getUserNm();
       System.out.println(address);
    }
}
