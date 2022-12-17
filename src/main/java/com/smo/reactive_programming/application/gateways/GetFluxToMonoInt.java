package com.smo.reactive_programming.application.gateways;

import com.smo.reactive_programming.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface GetFluxToMonoInt {

    ArrayList<Person> getPersons();

}
