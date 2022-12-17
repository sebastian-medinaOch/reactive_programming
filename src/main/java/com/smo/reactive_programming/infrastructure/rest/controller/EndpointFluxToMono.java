package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.GetFluxToMonoInt;
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
public class EndpointFluxToMono {

    private final GetFluxToMonoInt getFluxToMonoInt;

    @GetMapping(value = "/getFluxToMono")
    public Mono<ResponseEntity<AnswerData>> getPersons() {
        return Mono.just(getFluxToMonoInt.getPersons()).flatMap(person -> Mono.just(DataResponse.builder().message(
                        "Sastifactorio").data(Optional.of(person)).build())
                .flatMap(dataResponse -> Mono.just(new AnswerData(HttpStatus.OK, dataResponse))
                        .flatMap(answerData -> Mono.just(new ResponseEntity<>(answerData,
                                answerData.getStatus())))));

    }

}
