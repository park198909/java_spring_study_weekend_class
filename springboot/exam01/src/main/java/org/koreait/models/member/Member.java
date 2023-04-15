package org.koreait.models.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Setter @Getter @ToString
//@NoArgsConstructor(access=AccessLevel.PRIVATE)
//@RequiredArgsConstructor
@Builder @Log
public class Member {
    private Long userNo;
    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    public void info(){
        log.info("테스트 메시지!");
    }

}
