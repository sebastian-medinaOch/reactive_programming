package com.smo.reactive_programming.infrastructure.persistencia.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PERSON")
public class PersonEntity {

    @Id
    private Long personId;
    private String clientName;
    private String clientLastName;
    private String clientYear;
    private String clientCity;
    private String clientTypeDoc;
    private String clientNumDoc;

}
