package com.smo.reactive_programming.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private Long personId;
    private String clientName;
    private String clientLastName;
    private String clientYear;
    private String clientCity;
    private String clientTypeDoc;
    private String clientNumDoc;

}
