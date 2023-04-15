package org.koreait.exam_builderPattern;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class User2 {
    private String userId;
    private String userPw;
    private String userNm;
}
