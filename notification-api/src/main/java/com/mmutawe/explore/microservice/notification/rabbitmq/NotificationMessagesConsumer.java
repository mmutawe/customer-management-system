package com.mmutawe.explore.microservice.notification.rabbitmq;

import com.mmutawe.explore.microservice.clients.customer.auth.dtos.NotificationRequest;
import com.mmutawe.explore.microservice.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationMessagesConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consume(Object notificationRequest){
        log.info("fetching data from queue: {} ");
//        notificationService.send(notificationRequest);
    }
}
