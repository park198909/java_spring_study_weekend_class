package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  // SQL INSERT 실행 시 추가
    @Column(updatable = false)  // 수정(UPDATE) 불가
    private LocalDateTime regDt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp    // SQL UPDATE 실행 시 추가
    @Column(insertable = false) // 추가(INSERT) 불가
    private LocalDateTime modDt;
}
