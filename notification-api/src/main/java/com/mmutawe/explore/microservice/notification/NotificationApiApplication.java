package com.mmutawe.explore.microservice.notification;

import com.mmutawe.explore.microservice.amqp.producers.RabbitMQProducer;
import com.mmutawe.explore.microservice.notification.configs.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication(
//        scanBasePackages = {
//                "com.mmutawe.explore.microservice.notification",
//                "com.mmutawe.explore.microservice.amqp"
//        }
)
public class NotificationApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApiApplication.class, args);
    }

    // testing rabbitmq producer
//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQProducer producer,
//            NotificationConfig notificationConfig
//    ){
//        return args -> {
//            producer.publish(
//                    "hello world!",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getRoutingKey()
//            );
//        };
//    }
}
