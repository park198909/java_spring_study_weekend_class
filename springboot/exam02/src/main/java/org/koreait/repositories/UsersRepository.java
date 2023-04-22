package org.koreait.repositories;

import org.koreait.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {   // 프록시 형태로 구현체 자동생성
    Users findByUserId(String userId);
}
