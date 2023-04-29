package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity {
    @Id @GeneratedValue
    private Long id;    // 게시글 번호

    @Column(length = 40, nullable = false)
    private String boardId; // 게시판 아이디

    @Column(nullable = false)
    private String subject; // 게시글 제목

    @Lob
    @Column(nullable = false)
    private String content; // 게시글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userNo")  // 외래키명 설정
    private Users user; // 외래키(회원)
}
