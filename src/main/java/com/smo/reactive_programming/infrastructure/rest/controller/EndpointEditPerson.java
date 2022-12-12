package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.EditPerson;
import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.domain.answer.AnswerData;
import com.smo.reactive_programming.domain.answer.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointEditPerson {

    private final EditPerson editPerson;

    @PutMapping("/editPerson")
    public Mono<ResponseEntity<AnswerData>> editPerson(@RequestBody PersonRequest personRequest) {
        return editPerson.editPerson(personRequest).flatMap(person -> Mono.just(
                        DataResponse.builder().message("Sastifactorio").data(Optional.of("Usuario " +
                                "actualizado sastifactoriamente")).build())
                .flatMap(dataResponse -> Mono.just(new AnswerData(HttpStatus.OK, dataResponse))
                        .flatMap(answerData -> Mono.just(new ResponseEntity<>(answerData, answerData.getStatus())))));
    }
}
