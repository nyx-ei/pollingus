package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.models.Notification;
import com.nyxei.pollingus.models.Payload;
import com.nyxei.pollingus.repositories.NotificationRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

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
    private ResponseEntity<?> listingNotifications(@RequestBody JSONObject payload){
        Notification notification = new Notification();
        StringBuilder keys = new StringBuilder();
        Iterator<String> iterator = payload.keys();
        while (iterator.hasNext()){
            keys.append(" ").append(iterator.next());
        }
        notification.setContent(keys.toString());
        notificationRepository.save(notification);
        return ResponseEntity.ok().build();
    }
}
