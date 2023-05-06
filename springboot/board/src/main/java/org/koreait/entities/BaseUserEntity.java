package org.koreait.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter @Setter
@MappedSuperclass
public abstract class BaseUserEntity extends BaseEntity{
    @CreatedBy
    @Column(updatable = false)  // 입력할때만
    private Long createdBy;
    
    @LastModifiedBy
    @Column(insertable = false) // 수정할때만
    private Long modifiedBy;
    
}
