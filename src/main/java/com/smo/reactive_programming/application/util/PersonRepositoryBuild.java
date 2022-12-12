package com.smo.reactive_programming.application.util;

import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

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

    public Mono<ArrayList<Person>> buildAllPersons(PersonEntity personEntities) {
        Mono<ArrayList<Person>> personArrayList = Mono.just(new ArrayList<>());

        return Mono.just(personEntities)
                .flatMap(personEntity -> personArrayList.doOnNext(e -> buildPerson(personEntities)
                        .doOnNext(e::add)));
        /*ArrayList<Person> personArrayList = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            Person person = buildPerson(personEntity);
            personArrayList.add(person);
        }
        return personArrayList;*/
    }

}
