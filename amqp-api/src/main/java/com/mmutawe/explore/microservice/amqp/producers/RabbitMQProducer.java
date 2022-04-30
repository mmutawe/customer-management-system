package com.mmutawe.explore.microservice.amqp.producers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQProducer {
    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info("publishing message to {} using routing key {}. Payload: {}",
                exchange, routingKey, payload);

        amqpTemplate.convertAndSend(exchange, routingKey, payload);

        log.info("message published!!!");
    }

}
