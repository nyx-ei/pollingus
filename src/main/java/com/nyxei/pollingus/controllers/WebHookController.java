package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.models.Notification;
import com.nyxei.pollingus.repositories.NotificationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private ResponseEntity<Integer> listenIncomingMessages(HttpServletRequest request){
        Notification notification = new Notification();
        notification.setContent(request.getParameter("hub.verify_token"));
        notificationRepository.save(notification);
        return ResponseEntity.ok(1158201444);
    }
}
