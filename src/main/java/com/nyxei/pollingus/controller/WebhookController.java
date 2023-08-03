package com.nyxei.pollingus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nyxei.pollingus.controller.*;
import com.nyxei.pollingus.controller.Payload.Request;
import com.nyxei.pollingus.model.MessageEntity;
import com.nyxei.pollingus.service.*;


@RestController

public class WebhookController {
    @Autowired
   private MessageEntityService messageService;
    
    private String VERIFY_TOKEN="Patricia";
   
    @GetMapping("/webhook")
    public ResponseEntity<String> verify(@RequestParam("hub.mode") String mode, @RequestParam("hub.verify_token") String verifyToken,
                                         @RequestParam("hub.challenge") String challenge) {
        if (mode != null && verifyToken != null) {
            if (mode.equals("subscribe") && verifyToken.equals(VERIFY_TOKEN)) {
                System.out.println("Webhook Verified");
                return ResponseEntity.ok(challenge);
            }
        }
        return ResponseEntity.status(403).body(null);
    }

    @PostMapping("/webhook")
    public void webhook(@RequestBody Request request) throws Exception {
    
        MessageEntity message = new MessageEntity();
        
        message.setUserName(request.getEntry()[0].getChanges()[0].getValue().getContacts()[0].getProfile().getName());
        message.setSenderNumber(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getFrom());
        message.setMessageType(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getType());
        message.setImageCaption(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getImage().getCaption());
        message.setMimeType(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getImage().getMimeType());
        message.setSha256(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getImage().getSha256());
        
        System.out.println(this.messageService.saveMessage(message));
        
    }
    
}