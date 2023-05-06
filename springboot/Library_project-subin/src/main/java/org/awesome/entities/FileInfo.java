package org.awesome.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Table(indexes={
        @Index(name="idx_fileInfo_gid", columnList = "gid, regDt"),
        @Index(name="idx_fileInfo_gid_location", columnList = "gid, location, regDt")
})
public class FileInfo extends BaseEntity{
    @Id @GeneratedValue
    private Long fileNo; // 실제 서버에 fileNo.확장자

    @Column(length=60, nullable = false)
    private String gid; // 그룹 ID

    @Column(length=60)
    private String location; // 그룹 내 위치

    @Column(length=100, nullable = false)
    private String filename; // 원본 파일명

    @Column(length=60, nullable = false)
    private String contentType; // 파일 형식
    
    private boolean success; // 그룹 작업 완료 여부

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userNo")
    private User user; // 파일을 올린 사용자
}
