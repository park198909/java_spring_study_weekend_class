package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;
import org.koreait.contants.UserType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNo;

    @Column(length=40, unique = true, nullable = false)
    private String userId;

    @Column(length=65, nullable = false)
    private String userPw;

    @Column(length=40, nullable = false)
    private String userNm;

    @Column(length=100)
    private String email;

    @Column(length=11)
    private String mobile;

    @Enumerated(EnumType.STRING)
    private UserType type = UserType.USER;

    //@OneToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="addressId")
    //private Address address;

    //@OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE) // BoardData user - 연관관계 매핑의 주인(외래키)
    //@ToString.Exclude // ToString 제외
    //private List<BoardData> boardDatas = new ArrayList<>();

    //@ManyToMany
    //private List<Product> products = new ArrayList<>();
}
