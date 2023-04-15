package org.koreait.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONResult<T> {
    private boolean success;
    private HttpStatus status;
    private T data;
    private String message;
}
