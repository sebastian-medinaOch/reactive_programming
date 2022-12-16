package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.GetFilterForAgeInt;
import com.smo.reactive_programming.domain.answer.AnswerData;
import com.smo.reactive_programming.domain.answer.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointFilterForAge {

    private final GetFilterForAgeInt getFilterForAgeInt;

    @GetMapping(value = "/getFilterForAge")
    public Mono<ResponseEntity<AnswerData>> getPersons() throws InterruptedException {
        return Mono.just(getFilterForAgeInt.getFilterForAge()).flatMap(person -> Mono.just(DataResponse.builder().message(
                        "Sastifactorio").data(Optional.of(person)).build())
                .flatMap(dataResponse -> Mono.just(new AnswerData(HttpStatus.OK, dataResponse))
                        .flatMap(answerData -> Mono.just(new ResponseEntity<>(answerData,
                                answerData.getStatus())))));

    }

}
