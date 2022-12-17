package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.GetFluxToMonoInt;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ServiceGetFluxToMono implements GetFluxToMonoInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    private static final Logger log = LoggerFactory.getLogger(ServiceRepeatFluxInt.class);

    @Override
    public ArrayList<Person> getPersons() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personUseCase.getPersons().doOnNext(e -> {
                    Person person = personRepositoryBuild.buildPersonNotMono(e);
                    personArrayList.add(person);
                })
                .collectList()
                .subscribe(p -> log.info(p.toString()));

        return personArrayList;
    }
}
