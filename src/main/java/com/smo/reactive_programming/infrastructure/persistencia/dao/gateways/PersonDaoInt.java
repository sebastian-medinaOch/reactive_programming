package com.smo.reactive_programming.infrastructure.persistencia.dao.gateways;

import com.smo.reactive_programming.infrastructure.persistencia.entity.PersonEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonDaoInt extends ReactiveMongoRepository<PersonEntity, String> {

}
