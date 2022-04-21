package com.mmutawe.explore.microservice.clients.customer.auth.controllers;

import com.mmutawe.explore.microservice.clients.customer.auth.dtos.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "notification-api",
        path = "api/v1/notification"
)
public interface NotificationFeign {
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
