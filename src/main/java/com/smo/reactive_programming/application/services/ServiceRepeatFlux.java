package com.smo.reactive_programming.application.services;

import com.smo.reactive_programming.application.gateways.GetRepeatFlux;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.model.Person;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
public class ServiceRepeatFlux implements GetRepeatFlux {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;

    private static final Logger log = LoggerFactory.getLogger(ServiceRepeatFlux.class);

    @Override
    public Mono<Person> getRepeatPerson(String clientNumDoc) {
        Mono<Person> personEntityMono =
                personUseCase.findByClientNumDoc(clientNumDoc)
                        .flatMap(personRepositoryBuild::buildPersonComplete);
        personEntityMono
                .repeat(3)
                .delayElements(Duration.ofSeconds(2))
                .subscribe(person -> log.info("Persona repetida " + person));

        return personEntityMono;
    }
}
