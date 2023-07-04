package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.models.Notification;
import com.nyxei.pollingus.models.Payload;
import com.nyxei.pollingus.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/webhook")
public class WebHookController {
    private final NotificationRepository notificationRepository;
    @Value("${webhook.token}")
    private String token;
    public WebHookController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    private ResponseEntity<?> listenIncomingMessages(@RequestParam(name = "hub.challenge") Integer challenge, @RequestParam(name = "hub.mode") String mode, @RequestParam(name = "hub.verify_token") String verify){
        if("subscribe".equals(mode) && token.equals(verify)) return ResponseEntity.ok(challenge);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    private ResponseEntity<?> listingNotifications(@RequestBody Payload payload){
        Notification notification = new Notification();
        notification.setContent(payload.toString());
        notificationRepository.save(notification);
        return ResponseEntity.ok().build();
    }
}
