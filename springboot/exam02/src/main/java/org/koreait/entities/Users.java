package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.commons.constants.UserType;

import java.time.LocalDateTime;

@Data   // @Getter @Setter @ToString @ EqualsAndHahCode @RequiredArgConstructor
@Entity
@Table(name="members", indexes={
        @Index(name="idx_user_nm", columnList="userNm"),
        @Index(name="idx_reg_dt_desc", columnList="regDt DESC")
})
public class Users extends BaseEntity {
    @Id @GeneratedValue
//    @TableGenerator(name="Users_seq", initialValue = 1, allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long userNo;

    @Column(length = 45, nullable = false, unique = true)
    private String userId;

    @Column(length = 65, nullable = false)
    private String userPw;

    @Column(length = 40, nullable = false)
    private String userNm;  // userName으로 써라

    @Column(length = 11)
    private String mobile;

//    @Transient  // 필드 생성 무시
    @Column(length = 100)
    private String email;

    @Lob
    private String intro;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private UserType type = UserType.USER;

}
