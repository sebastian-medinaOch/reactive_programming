package com.smo.reactive_programming.domain.answer;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AnswerData {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private DataResponse dataResponse;

    public AnswerData(HttpStatus status, DataResponse dataResponse){
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        this.timestamp = LocalDateTime.of(today,now);
        this.status = status;
        this.dataResponse = dataResponse;
    }
}
