package org.koreait.repositories;

import com.querydsl.core.BooleanBuilder;
import org.koreait.entities.QUsers;
import org.koreait.entities.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long>,    // 프록시 형태로 구현체를 자동생성
        QuerydslPredicateExecutor {
    Users findByUserId(String userId);

    Users findByUserIdAndUserNm(String userId,String userNm);

    List<Users> findByUserIdOrUserId(String userId1, String userId2);

    List<Users> findByUserIdIn(Collection<String> userIds);

    List<Users> findByUserIdInOrderByRegDtDesc(Collection<String> userIds);

    List<Users> findByUserNmContaining(String userNm);  // userNm LIKE '%키워드%';

    List<Users> findByUserIdContaining(String userId, Pageable pageable);

    @Query("SELECT u FROM Users u WHERE userNm LIKE %:key% ORDER BY u.regDt DESC")
    List<Users> findUsers(@Param("key") String keyword);

    default List<Users> findUsers2(String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
        QUsers users = QUsers.users;
        builder.or(users.userId.contains(keyword))
                .or(users.userNm.contains(keyword));

//        List<Users> list = (List<Users>)findAll(builder);

        List<Users> list = (List<Users>)findAll(users.userNm.contains(keyword));

        return list;
    }
}
