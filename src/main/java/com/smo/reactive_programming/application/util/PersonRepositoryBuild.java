package com.smo.reactive_programming.application.util;

import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import reactor.core.publisher.Mono;

public class PersonRepositoryBuild {

    public Mono<Person> buildPersonComplete(PersonEntity personEntity) {
        return buildPerson(personEntity);
    }

    public Mono<Person> buildPerson(PersonEntity personEntity) {
        return Mono.just(
                Person.builder().personId(personEntity.getPersonId())
                        .clientName(personEntity.getClientName())
                        .clientLastName(personEntity.getClientLastName())
                        .clientYear(personEntity.getClientYear())
                        .clientCity(personEntity.getClientCity())
                        .clientTypeDoc(personEntity.getClientTypeDoc())
                        .clientNumDoc(personEntity.getClientNumDoc())
                        .build());
    }

    public Person buildPersonNotMono(PersonEntity personEntity) {
        return Person.builder().personId(personEntity.getPersonId())
                .clientName(personEntity.getClientName())
                .clientLastName(personEntity.getClientLastName())
                .clientYear(personEntity.getClientYear())
                .clientCity(personEntity.getClientCity())
                .clientTypeDoc(personEntity.getClientTypeDoc())
                .clientNumDoc(personEntity.getClientNumDoc())
                .build();
    }

    public Mono<PersonEntity> buildPersonEntity(PersonRequest personRequest) {
        PersonEntity personBuild = new PersonEntity();
        personBuild.setClientName(personRequest.getClientName());
        personBuild.setClientLastName(personRequest.getClientLastName());
        personBuild.setClientYear(personRequest.getClientYear());
        personBuild.setClientCity(personRequest.getClientCity());
        personBuild.setClientTypeDoc(personRequest.getClientTypeDoc());
        personBuild.setClientNumDoc(personRequest.getClientNumDoc());

        return Mono.just(personBuild);
    }

    public Mono<PersonEntity> buildPersonEntityFull(PersonEntity personEntityDataBase, PersonRequest personRequest) {
        personEntityDataBase.setClientName(personRequest.getClientName());
        personEntityDataBase.setClientLastName(personRequest.getClientLastName());
        personEntityDataBase.setClientYear(personRequest.getClientYear());
        personEntityDataBase.setClientCity(personRequest.getClientCity());
        personEntityDataBase.setClientTypeDoc(personRequest.getClientTypeDoc());
        personEntityDataBase.setClientNumDoc(personRequest.getClientNumDoc());

        return Mono.just(personEntityDataBase);
    }


}
