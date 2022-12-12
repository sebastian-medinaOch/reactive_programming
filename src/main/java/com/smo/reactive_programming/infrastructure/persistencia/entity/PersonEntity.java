package com.smo.reactive_programming.infrastructure.persistencia.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "PERSONS")
public class PersonEntity {

    @Id
    private String personId;
    private String clientName;
    private String clientLastName;
    private String clientYear;
    private String clientCity;
    private String clientTypeDoc;
    private String clientNumDoc;

}
