package org.koreait.exam_builderPattern;

public class Ex02 {
    public static void main(String[] args) {
        User2 user2 = User2.builder()
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .build();
        System.out.println(user2);
    }
}
