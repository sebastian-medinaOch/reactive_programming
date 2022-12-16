package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.GetFilterForAgeInt;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ServicesGetFilterForAge implements GetFilterForAgeInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    private static final Logger log = LoggerFactory.getLogger(ServiceRepeatFluxInt.class);

    @Override
    public ArrayList<Person> getFilterForAge() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personUseCase.getPersons()
                .filter(personEntity -> Integer.parseInt(personEntity.getClientYear()) >= 10)
                //.take(1)
                //.takeLast(1)
                //.skip(1)
                .doOnNext(e -> {
                    Person person = personRepositoryBuild.buildPersonNotMono(e);
                    personArrayList.add(person);
                })
                .subscribe(person -> log.info(person.toString()));


        return personArrayList;
    }

}
