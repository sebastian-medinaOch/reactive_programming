package com.smo.reactive_programming.infrastructure.persistencia.respository;

import com.smo.reactive_programming.domain.gateways.PersonRepositoryInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonRepositoryInt {

}
