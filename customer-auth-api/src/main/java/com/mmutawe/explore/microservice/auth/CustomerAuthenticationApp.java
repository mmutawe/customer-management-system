package com.mmutawe.explore.microservice.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CustomerAuthenticationApp {
    public static void main(String[] args) {
        SpringApplication.run(CustomerAuthenticationApp.class, args);
    }
}
