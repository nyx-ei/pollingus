package com.nyxei.pollingus;


import com.nyxei.pollingus.domain.messages.BodyComponent;
import com.nyxei.pollingus.domain.messages.Language;
import com.nyxei.pollingus.domain.messages.Message.MessageBuilder;
import com.nyxei.pollingus.domain.messages.TemplateMessage;
import com.nyxei.pollingus.domain.messages.TextParameter;
import com.nyxei.pollingus.domain.templates.type.LanguageType;
import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;

import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_1;
import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_ID;

public class SendTemplateButtonMessageExample {
    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
 
        var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage( new TemplateMessage()
                        .setLanguage(new Language(LanguageType.EN_US)).setName("sample_issue_resolution")//
                                .addComponent(new BodyComponent()//
                                        .addParameter(new TextParameter("Hi!")//
                                        ))
                );

/**
 * TextMessage text =  new TextMessage();
 * var message = MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTextMessage(text.setBody("Hello Patricia")
                );
 */

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}
