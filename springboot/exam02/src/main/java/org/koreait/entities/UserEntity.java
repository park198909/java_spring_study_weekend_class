package org.koreait.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UserEntity {
    @Id
    private Long userNo;
    private String userId;
    private String userPw;
    private String userNm;

    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
