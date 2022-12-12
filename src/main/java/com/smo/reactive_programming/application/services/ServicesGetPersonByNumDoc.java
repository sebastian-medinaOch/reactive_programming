package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.GetPersonByNumDocInt;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ServicesGetPersonByNumDoc implements GetPersonByNumDocInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    @Override
    public Mono<Person> getPersonByNumDoc(String clientNumDoc) {

        return personUseCase.findByClientNumDoc(clientNumDoc).flatMap(personRepositoryBuild::buildPersonComplete);

    }


}
