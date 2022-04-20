package com.mmutawe.explore.microservice.auth.controllers;

import com.mmutawe.explore.microservice.auth.entities.CustomerAuthHistory;
import com.mmutawe.explore.microservice.auth.services.CustomerAuthHistoryService;
import com.mmutawe.explore.microservice.clients.customer.auth.dtos.CustomerAuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/auth-check")
public class CustomerAuthHistoryController {

    private final CustomerAuthHistoryService service;

    @GetMapping(path = "{customerId}")
    public CustomerAuthResponse isCustomerAuthorized(@PathVariable("customerId") Long customerId){

        return service.isCustomerAuthorized(customerId);
    }
}
