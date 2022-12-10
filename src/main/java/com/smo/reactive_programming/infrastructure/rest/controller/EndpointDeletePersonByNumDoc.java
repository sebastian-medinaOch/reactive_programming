package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.DeletePersonInt;
import com.smo.reactive_programming.domain.answer.AnswerData;
import com.smo.reactive_programming.domain.answer.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class EndpointDeletePersonByNumDoc {

    private final DeletePersonInt deletePersonInt;

    @DeleteMapping("/deletePerson/{clientNumDoc}")
    public Mono<ResponseEntity<AnswerData>> deletePerson(@PathVariable String clientNumDoc) {
        return deletePersonInt.deletePersonByClientNumDoc(clientNumDoc).then(
                Mono.just(DataResponse.builder().message("Sastifactorio").data(Optional.of("El cliente que se " +
                                "eliminó" +
                                " fue con el numero de documento: " + clientNumDoc)).build())
                        .flatMap(dataResponse -> Mono.just(new AnswerData(HttpStatus.OK, dataResponse))
                                .flatMap(answerData -> Mono.just(new ResponseEntity<>(answerData, answerData.getStatus())))));
    }

}
