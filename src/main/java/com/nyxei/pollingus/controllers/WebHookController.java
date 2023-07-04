package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.models.Notification;
import com.nyxei.pollingus.repositories.NotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/webhook")
public class WebHookController {
    private final NotificationRepository notificationRepository;

    public WebHookController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    private void listenIncomingMessages(HttpServletRequest request){
        Notification notification = new Notification();
        notification.setContent(request.getParameterMap().toString());
        notificationRepository.save(notification);
    }
}
