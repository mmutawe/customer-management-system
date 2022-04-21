package com.mmutawe.explore.microservice.notification.controllers;

import com.mmutawe.explore.microservice.clients.customer.auth.dtos.NotificationRequest;
import com.mmutawe.explore.microservice.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService service;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        service.send(notificationRequest);
    }
}
