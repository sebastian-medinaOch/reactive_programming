package com.smo.reactive_programming.domain.gateways;

import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

public interface PersonRepositoryInt {

    Mono<PersonEntity> savePerson(PersonEntity personEntity);
    Mono<Void> deletePersonByClientNumDoc(PersonEntity personEntity);

    Mono<PersonEntity> findByClientNumDoc(String clientNumDoc);

    Flux<PersonEntity> getPersons();
}
