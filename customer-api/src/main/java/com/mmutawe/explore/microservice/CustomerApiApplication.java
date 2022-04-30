package com.mmutawe.explore.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.mmutawe.explore.microservice.clients.customer.auth"
)
@SpringBootApplication(
        scanBasePackages = {
                "com.mmutawe.explore.microservice",
                "com.mmutawe.explore.microservice.amqp"
        }
)
public class CustomerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApiApplication.class, args);
    }
}
