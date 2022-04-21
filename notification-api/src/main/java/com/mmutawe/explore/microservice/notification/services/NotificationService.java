package com.mmutawe.explore.microservice.notification.services;

import com.mmutawe.explore.microservice.clients.customer.auth.dtos.NotificationRequest;
import com.mmutawe.explore.microservice.notification.entities.Notification;
import com.mmutawe.explore.microservice.notification.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public void send(NotificationRequest request) {
        Notification notify = Notification.builder()
                .customerId(request.getCustomerId())
                .customerEmail(request.getCustomerEmail())
                .message(request.getMessage())
                .sentAt(LocalDateTime.now())
                .build();

        repository.save(notify);
    }
}
