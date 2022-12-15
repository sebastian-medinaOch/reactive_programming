package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.GetRepeatFluxInt;
import com.smo.reactive_programming.application.services.ServiceRepeatFluxInt;
import com.smo.reactive_programming.domain.answer.AnswerData;
import com.smo.reactive_programming.domain.answer.DataResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointRepeatFlux {

    private final GetRepeatFluxInt getRepeatFluxInt;

    private static final Logger log = LoggerFactory.getLogger(ServiceRepeatFluxInt.class);

    @GetMapping(value = "/getRepeatFlux")
    public Mono<ResponseEntity<AnswerData>> getRepeatFluxx(@RequestParam("clientNumDoc") String clientNumDoc) {

        return getRepeatFluxInt.getRepeatPerson(clientNumDoc)
                .flatMap(person -> Mono.just(DataResponse.builder().message(
                                "Sastifactorio").data(Optional.of(person)).build())
                        .flatMap(dataResponse -> Mono.just(new AnswerData(HttpStatus.OK, dataResponse))
                                .flatMap(answerData -> Mono.just(new ResponseEntity<>(answerData,
                                        answerData.getStatus())))));
    }

}
