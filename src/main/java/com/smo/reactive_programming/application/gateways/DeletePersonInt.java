package com.smo.reactive_programming.application.gateways;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DeletePersonInt {

    Mono<Void> deletePersonByClientNumDoc(String clientNumDoc);

}
