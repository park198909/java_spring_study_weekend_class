package org.koreait.restControllers;

import org.koreait.commons.CommonException;
import org.koreait.commons.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.koreait.restControllers")
public class CommonRestController {     // RestController의 공통기능 설정
    @ExceptionHandler(Exception.class)  // 예외를 통제하는 기능
    public ResponseEntity<JSONResult<Object>> errorHandler(Exception e){
        e.printStackTrace();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;   // 기본 상태 코드 500
        if(e instanceof CommonException){
            CommonException ce = (CommonException)e;
            status = ce.getStatus();
        }

        JSONResult<Object> jsonResult = new JSONResult<>();
        jsonResult.setSuccess(false);
        jsonResult.setMessage(e.getMessage());
        jsonResult.setStatus(status);

        return ResponseEntity.status(status).body(jsonResult);
    }
}
