package com.mmutawe.explore.microservice.clients.customer.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAuthResponse {
    private Long customerId;
    private Boolean isAuthorized;
}