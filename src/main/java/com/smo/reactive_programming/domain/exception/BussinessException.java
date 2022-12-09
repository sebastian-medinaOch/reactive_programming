package com.smo.reactive_programming.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BussinessException extends Exception{

    private final HttpStatus status;
    private final String detail;

    public BussinessException(HttpStatus status, String detail) {
        this.status = status;
        this.detail = detail;
    }

}
