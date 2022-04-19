package com.mmutawe.explore.microservice.services;

import com.mmutawe.explore.microservice.dtos.CustomerAuthResponse;
import com.mmutawe.explore.microservice.dtos.CustomerRequest;
import com.mmutawe.explore.microservice.entities.Customer;
import com.mmutawe.explore.microservice.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerService(CustomerRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Customer registerCustomer(CustomerRequest customerRequest){

        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        repository.saveAndFlush(customer);

        // check if customer is authorized
        CustomerAuthResponse customerAuthResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/auth-check/{customerId}",
                CustomerAuthResponse.class,
                customer.getId());

        log.info("customer authorized id: {}", customerAuthResponse.getCustomerId());

        if(!customerAuthResponse.getIsAuthorized()){
//            throw new IllegalStateException("customer is not authorized");
            log.error("customer is not authorized");
        }
        return customer;
    }
}
