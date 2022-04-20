package com.mmutawe.explore.microservice.clients.customer.auth.controllers;

import com.mmutawe.explore.microservice.clients.customer.auth.dtos.CustomerAuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "customer-auth-api",
        path = "api/v1/auth-check"
//        configuration = CustomerConfig.class
)
public interface CustomerAuth {
    @GetMapping(path = "{customerId}")
    public CustomerAuthResponse isCustomerAuthorized(@PathVariable("customerId") Long customerId);
}
