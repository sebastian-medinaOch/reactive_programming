package com.smo.reactive_programming.domain.answer;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AnswerException {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

    public AnswerException(HttpStatus status, String message){
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        this.timestamp = LocalDateTime.of(today,now);
        this.status = status;
        this.message = message;
    }

}
