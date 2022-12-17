package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.GetCombinationFluxInt;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ServicesGetCombinationFlux implements GetCombinationFluxInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    private static final Logger log = LoggerFactory.getLogger(ServiceRepeatFluxInt.class);


    @Override
    public ArrayList<ArrayList<Person>> getPersons() {
        ArrayList<ArrayList<Person>> personArrayListComplete = new ArrayList<>();

        ArrayList<Person> personasFirst = new ArrayList<>();
        personasFirst.add(Person.builder().personId("1").build());

        ArrayList<Person> personaSecond = new ArrayList<>();
        personaSecond.add(Person.builder().personId("2").build());

        personArrayListComplete.add(personasFirst);
        personArrayListComplete.add(personaSecond);

        Flux<Person> flx1 = Flux.fromIterable(personasFirst);
        Flux<Person> flx2 = Flux.fromIterable(personaSecond);

        Flux.merge(flx1, flx2)
                .subscribe(p -> log.info(p.toString()));

        /*Flux.zip(flx1,flx2)
                .subscribe(x-> log.info(x.toString()));*/

       /* flx1.zipWith(flx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s",p1, p2))
                .subscribe(log::info);*/


        return personArrayListComplete;
    }
}
