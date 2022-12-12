package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.EditPerson;
import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ServiceEditPerson implements EditPerson {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    @Override
    public Mono<Person> editPerson(PersonRequest personRequestMono) {

        return personUseCase.findByClientNumDoc(personRequestMono.getClientNumDoc())
                .flatMap(personEntityRepository -> personRepositoryBuild.buildPersonEntityFull(personEntityRepository,
                                personRequestMono)
                        .flatMap(personBuildFull -> personUseCase.createPerson(personBuildFull)
                                .flatMap(personRepositoryBuild::buildPersonComplete)));

    }

}
