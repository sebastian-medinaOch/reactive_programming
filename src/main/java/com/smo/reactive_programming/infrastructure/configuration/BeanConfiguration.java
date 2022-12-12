package com.smo.reactive_programming.infrastructure.configuration;

import com.smo.reactive_programming.application.services.ServiceCreatePerson;
import com.smo.reactive_programming.application.services.ServiceDeletePerson;
import com.smo.reactive_programming.application.services.ServicesGetPersonByNumDoc;
import com.smo.reactive_programming.application.services.ServicesGetPersons;
import com.smo.reactive_programming.application.util.PersonRepositoryBuild;
import com.smo.reactive_programming.domain.gateways.PersonRepositoryInt;
import com.smo.reactive_programming.domain.usecase.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ServiceCreatePerson serviceCreatePerson(PersonUseCase personUseCase,
                                                   PersonRepositoryBuild personRepositoryBuild) {
        return new ServiceCreatePerson(personUseCase, personRepositoryBuild);
    }

    @Bean
    public ServiceDeletePerson serviceDeletePerson(PersonUseCase personUseCase){
        return new ServiceDeletePerson(personUseCase);
    }

    @Bean
    public PersonUseCase personUseCase(PersonRepositoryInt personRepositoryInt) {
        return new PersonUseCase(personRepositoryInt);
    }

    @Bean
    public PersonRepositoryBuild personRepositoryBuild(){
        return new PersonRepositoryBuild();
    }


    @Bean
    public ServicesGetPersonByNumDoc servicesGetPerson(PersonUseCase personUseCase,
                                                       PersonRepositoryBuild personRepositoryBuild){
        return new ServicesGetPersonByNumDoc(personUseCase, personRepositoryBuild);
    }

    @Bean
    public ServicesGetPersons servicesGetPersons(PersonUseCase personUseCase, PersonRepositoryBuild personRepositoryBuild){
        return new ServicesGetPersons(personUseCase, personRepositoryBuild);
    }

}
