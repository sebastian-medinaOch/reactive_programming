package com.smo.reactive_programming.application.gateways;

import com.smo.reactive_programming.application.request.PersonRequest;
import com.smo.reactive_programming.domain.model.Person;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EditPersonInt {

    Mono<Person> editPerson(PersonRequest personRequestMono);

}
