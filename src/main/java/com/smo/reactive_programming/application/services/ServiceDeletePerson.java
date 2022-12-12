package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.DeletePersonInt;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ServiceDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;


    @Override
    public Mono<Void> deletePersonByClientNumDoc(String clientNumDoc) {
        return personUseCase.findByClientNumDoc(clientNumDoc).flatMap(personUseCase::deletePersonByClientNumDoc);
    }
}
