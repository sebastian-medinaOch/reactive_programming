package com.smo.reactive_programming.domain.usecase;

import com.smo.reactive_programming.domain.gateways.PersonRepositoryInt;
import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepositoryInt personRepositoryInt;

    public Mono<PersonEntity> createPerson(PersonEntity personEntity) {
        return personRepositoryInt.savePerson(personEntity);
    }

    public Mono<Void> deletePersonByClientNumDoc(PersonEntity personEntity) {
        return personRepositoryInt.deletePersonByClientNumDoc(personEntity);
    }

    public Mono<PersonEntity> findByClientNumDoc(String clientNumDoc) {
        return personRepositoryInt.findByClientNumDoc(clientNumDoc);
    }

    public Flux<PersonEntity> getPersons() {
        return personRepositoryInt.getPersons();
    }
}
