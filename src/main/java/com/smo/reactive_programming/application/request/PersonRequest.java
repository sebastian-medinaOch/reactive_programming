package com.smo.reactive_programming.application.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonRequest {

    @NotBlank(message = "El nombre del cliente no puede estar vacio")
    private String clientName;
    @NotBlank(message = "El apellido del cliente no puede estar vacio")
    private String clientLastName;
    @NotBlank(message = "Los años del cliente no puede estar vacio")
    private String clientYear;
    @NotBlank(message = "La ciudad del cliente no puede estar vacia")
    private String clientCity;
    @NotBlank(message = "El tipo de documento del cliente no puede estar vacio")
    private String clientTypeDoc;
    @NotBlank(message = "El numero de documento del cliente no puede estar vacio")
    @Digits(integer = 10, fraction = 0, message = "El numero de documento del cliente solo puede contener numeros y " +
            "tiene que ser menor de 10 digitos")
    private String clientNumDoc;

}
