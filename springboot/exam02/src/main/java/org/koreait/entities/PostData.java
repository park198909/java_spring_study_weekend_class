package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class PostData extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 150, nullable = false)
    private String suject;  // 게시글 제목

    @Lob
    @Column(nullable = false)
    private String content; // 게시글 내용

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="user_no")
    private Users user;
}
