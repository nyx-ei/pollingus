package com.nyxei.pollingus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nyxei.pollingus.controller.*;
import com.nyxei.pollingus.controller.Payload.Request;


@RestController


public class WebhookController {
    public static String messageType;
    public static String profileName;
    public static String caption;
   
    @GetMapping("/webhook")
    public ResponseEntity<String> verify(@RequestParam("hub.mode") String mode, @RequestParam("hub.verify_token") String verifyToken,
                                         @RequestParam("hub.challenge") String challenge) {
        if (mode != null && verifyToken != null) {
            if (mode.equals("subscribe") && verifyToken.equals("${VERIFY_TOKEN}")) {
                System.out.println("Webhook Verified");
                return ResponseEntity.ok(challenge);
            }
        }
        return ResponseEntity.status(403).body(null);
    }

    @PostMapping("/webhook")
    public void webhook(@RequestBody Request request) throws Exception {
        messageType = request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getType();
        caption = request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getImage().getCaption();
        profileName = request.getEntry()[0].getChanges()[0].getValue().getContacts()[0].getProfile().getName();
        
       
         System.out.println(messageType +" "+caption+" "+profileName);
       // MessageEntity message = new MessageEntity();
        //message.setSenderNumber(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getFrom());
        //message.setMessage(request.getEntry()[0].getChanges()[0].getValue().getMessages()[0].getText().getBody());
       // message.setTimestamp(new Date()); //TODO : change to message timing
        //messageEntityRepository.save(message);
    }
   

    
}
