package com.nyxei.pollingus;


import com.nyxei.pollingus.domain.Language;
import com.nyxei.pollingus.domain.messages.*;
import com.nyxei.pollingus.domain.messages.Message.MessageBuilder;
import com.nyxei.pollingus.domain.templates.type.LanguageType;
import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;

import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_1;
import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_ID;
import static java.awt.SystemColor.text;

public class SendTemplateButtonMessageExample {
    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.getInstanceApiFactory(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.getInstanceBusinessCloudApi();

        var message = MessageBuilder.builder()//
            .setTo(PHONE_NUMBER_1)//
            .buildTemplateMessage( new TemplateMessage()
                .setLanguage(new Language(LanguageType.FR)).setName("nouvelle_offre")//
                .addComponent(new BodyComponent(text)
                   // .addParameter(new TextParameter("What type of management do you agree with?"))
                   // .addParameter(new TextParameter("1-Directive management  2-Persuasive management"))
                )
            );

       whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}


