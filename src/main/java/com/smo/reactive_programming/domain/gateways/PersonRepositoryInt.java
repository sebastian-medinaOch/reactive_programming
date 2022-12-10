package com.smo.reactive_programming.domain.gateways;

import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import reactor.core.publisher.Mono;

public interface PersonRepositoryInt {

    Mono<PersonEntity> savePerson(PersonEntity personEntity);
    Mono<Void> deletePersonByClientNumDoc(PersonEntity personEntity);

    Mono<PersonEntity> findByClientNumDoc(String clientNumDoc);

}
