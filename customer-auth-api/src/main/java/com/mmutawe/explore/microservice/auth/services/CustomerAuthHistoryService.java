package com.mmutawe.explore.microservice.auth.services;

import com.mmutawe.explore.microservice.auth.entities.CustomerAuthHistory;
import com.mmutawe.explore.microservice.auth.repositories.CustomerAuthHistoryRepository;
import com.mmutawe.explore.microservice.clients.customer.auth.dtos.CustomerAuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerAuthHistoryService {

    private final CustomerAuthHistoryRepository repository;

    public CustomerAuthResponse isCustomerAuthorized(Long customerId) {

        CustomerAuthHistory customerAuthHistory = CustomerAuthHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isAuthorized(customerId % 2 == 1)
                .build();

        repository.save(customerAuthHistory);

        return new CustomerAuthResponse(customerId, customerAuthHistory.getIsAuthorized());
    }
}
