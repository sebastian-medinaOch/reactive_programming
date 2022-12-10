package com.smo.reactive_programming.infrastructure.rest.controller;

import com.smo.reactive_programming.application.gateways.CreatePersonInt;
import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.domain.answer.AnswerData;
import com.smo.reactive_programming.domain.answer.DataResponse;
import com.smo.reactive_programming.domain.exception.BussinessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointCreatePerson {

    private final CreatePersonInt createPersonInt;

    @PostMapping(value = "/createPerson")
    public Mono<ResponseEntity<AnswerData>> createPerson(@Valid @RequestBody Mono<PersonRequest> personRequest) throws BussinessException {
        return createPersonInt.createPerson(personRequest).flatMap(person -> {
            DataResponse dataResponse = DataResponse.builder().message("Sastifactorio").data(Optional.of("Usuario " +
                    "creado sastifactoriamente")).build();
            AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse);
            return Mono.just(new ResponseEntity<>(answerData, answerData.getStatus()));
        });
    }

}
