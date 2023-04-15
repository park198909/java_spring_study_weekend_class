package org.koreait.exam_builderPattern;

public class Ex01 {
    public static void main(String[] args) {
        User user = User.builder()
                    .userId("user01")
                    .userNm("사용자01")
                    .userPw("0123456")
                    .build();
        System.out.println(user);
    }
}
