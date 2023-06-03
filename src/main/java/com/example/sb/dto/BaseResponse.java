package com.example.sb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BaseResponse<T> {

    private HttpStatus status;
    private T body;
    private LocalDateTime timestamp;

}
