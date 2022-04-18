package com.mmutawe.explore.microservice.dtos;

import lombok.Data;

@Data
public class CustomerRequest {
    String firstName;
    String lastName;
    String email;
}
