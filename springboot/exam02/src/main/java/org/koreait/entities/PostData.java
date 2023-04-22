package org.koreait.entities;

import jakarta.persistence.*;

@Entity
public class PostData extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 150, nullable = false)
    private String suject;  // 게시글 제목

    @Lob
    @Column(nullable = false)
    private String content; // 게시글 내용

}
