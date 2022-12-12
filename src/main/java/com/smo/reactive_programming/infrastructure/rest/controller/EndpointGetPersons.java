package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.GetPersonsInt;
import com.smo.reactive_programming.domain.answer.AnswerData;
import com.smo.reactive_programming.domain.answer.DataResponse;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointGetPersons {

    private final GetPersonsInt getPersonsInt;

    private static final Logger log = LoggerFactory.getLogger(EndpointGetPersons.class);

    @GetMapping(value = "/getPersons")
    public Mono<ResponseEntity<AnswerData>> getPersons() {
        return Mono.just(getPersonsInt.getPersons()).flatMap(person -> Mono.just(DataResponse.builder().message("Sastifactorio").data(Optional.of(person)).build())
                .flatMap(dataResponse -> Mono.just(new AnswerData(HttpStatus.OK, dataResponse))
                        .flatMap(answerData -> Mono.just(new ResponseEntity<>(answerData,
                                answerData.getStatus())))));

    }

}
