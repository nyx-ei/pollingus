package com.nyxei.pollingus;

import com.nyxei.pollingus.TestUtils;
import com.nyxei.pollingus.WhatsappApiFactory;
import com.nyxei.pollingus.controller.WebhookController;
import com.nyxei.pollingus.domain.messages.Message.MessageBuilder;
import com.nyxei.pollingus.domain.messages.TextMessage;
import com.nyxei.pollingus.domain.messages.response.MessageResponse;
import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;


import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_1;
import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_ID;


public class SendTextMessageExample {

    public static void main(String[] args) {

         WhatsappApiFactory factory = WhatsappApiFactory.getInstanceApiFactory(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.getInstanceBusinessCloudApi();
        var message = MessageBuilder.builder()//
        .setTo(PHONE_NUMBER_1)//
        .buildTextMessage(new TextMessage()//
                .setBody("Hello world!"+ WebhookController.profileName + "\n Please answer with a media JPEG or PNG format, with a maximum size of 4 Mo.\n" )//
                .setPreviewUrl(false));

        
            MessageResponse messageResponse = whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
            System.out.println(messageResponse);
    
        

    }
}
