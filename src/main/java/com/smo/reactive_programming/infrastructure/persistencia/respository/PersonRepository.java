package com.smo.reactive_programming.infrastructure.persistencia.respository;

import com.smo.reactive_programming.domain.gateways.PersonRepositoryInt;
import com.smo.reactive_programming.infrastructure.persistencia.dao.gateways.PersonDaoInt;
import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonRepositoryInt {

    private final PersonDaoInt personDaoInt;

    @Override
    public Mono<PersonEntity> savePerson(PersonEntity personEntity) {
        return personDaoInt.save(personEntity);
    }

    public Mono<Void> deletePersonByClientNumDoc(PersonEntity personEntity) {
        return personDaoInt.delete(personEntity);
    }
    public Mono<PersonEntity> findByClientNumDoc(String clientNumDoc){
        return personDaoInt.findByClientNumDoc(clientNumDoc);
    }

}
