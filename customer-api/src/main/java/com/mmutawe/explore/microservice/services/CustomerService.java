package com.mmutawe.explore.microservice.services;

//import com.mmutawe.explore.microservice.dtos.CustomerAuthResponse;
import com.mmutawe.explore.microservice.clients.customer.auth.controllers.CustomerAuth;
import com.mmutawe.explore.microservice.clients.customer.auth.controllers.NotificationFeign;
import com.mmutawe.explore.microservice.clients.customer.auth.dtos.CustomerAuthResponse;
import com.mmutawe.explore.microservice.clients.customer.auth.dtos.NotificationRequest;
import com.mmutawe.explore.microservice.dtos.CustomerRequest;
import com.mmutawe.explore.microservice.entities.Customer;
import com.mmutawe.explore.microservice.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerAuth customerAuthClient;
    private final NotificationFeign notificationFeign;
//    private final RestTemplate restTemplate;

    @Autowired
    public CustomerService(CustomerRepository repository, /*RestTemplate restTemplate,*/ CustomerAuth customerAuthClient, NotificationFeign notificationFeign) {
        this.repository = repository;
//        this.restTemplate = restTemplate;
        this.customerAuthClient = customerAuthClient;
        this.notificationFeign = notificationFeign;
    }

    public Customer registerCustomer(CustomerRequest customerRequest){

        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        repository.saveAndFlush(customer);

        // check if customer is authorized
//        CustomerAuthResponse customerAuthResponse = restTemplate.getForObject(
//                "http://customer-auth-api/api/v1/auth-check/{customerId}",
//                CustomerAuthResponse.class,
//                customer.getId());

        CustomerAuthResponse customerAuthResponse = customerAuthClient.isCustomerAuthorized(customer.getId());

        log.info("customer authorized id: {}", customerAuthResponse.getCustomerId());

        if(!customerAuthResponse.getIsAuthorized()){
//            throw new IllegalStateException("customer is not authorized");
            log.error("customer is not authorized");
        }

        // send notification
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .customerId(customer.getId())
                .customerEmail(customer.getEmail())
                .message("a test notification message...")
                .build();
        notificationFeign.sendNotification(notificationRequest);

        return customer;
    }
}
