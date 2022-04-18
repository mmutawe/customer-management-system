package com.mmutawe.explore.microservice.services;

import com.mmutawe.explore.microservice.dtos.CustomerRequest;
import com.mmutawe.explore.microservice.entities.Customer;
import com.mmutawe.explore.microservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer registerCustomer(CustomerRequest customerRequest){

        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        repository.save(customer);
        return customer;
    }
}
