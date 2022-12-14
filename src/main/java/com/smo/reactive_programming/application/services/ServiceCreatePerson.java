package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.CreatePersonInt;
import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    @Override
    public Mono<Person> createPerson(Mono<PersonRequest> personRequest) {
        return personRequest.flatMap(personaFlatMap -> personRepositoryBuild.buildPersonEntity(personaFlatMap)
                .flatMap(personEntityFlatMap -> personUseCase.createPerson(personEntityFlatMap)
                        .flatMap(personRepositoryBuild::buildPersonComplete)));
    }
}
