package org.awesome.controllers.admin;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserListForm {

    private String mode;
    @NotBlank
    private Long userNo;
    @NotBlank
    private String userNm;
    @NotBlank
    private String userId;
    @NotBlank
    private LocalDateTime regDt;
    @NotBlank
    private String userType;

}