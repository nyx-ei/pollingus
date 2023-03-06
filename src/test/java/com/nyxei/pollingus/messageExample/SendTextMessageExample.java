package com.nyxei.pollingus.messageExample;

import com.nyxei.pollingus.TestUtils;
import com.nyxei.pollingus.WhatsappApiFactory;
import com.nyxei.pollingus.domain.messages.Message.MessageBuilder;
import com.nyxei.pollingus.domain.messages.TextMessage;
import com.nyxei.pollingus.exception.utils.Formatter;
import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;

import  com.nyxei.pollingus.model.Digester;
import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_ID;

public class SendTextMessageExample {

    public static void main(String[] args) {

        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();
        //var salut="Hello world!";
        
        var message = MessageBuilder.builder()//
                .setTo(Digester.survey.getDestinataireList().get(0))//
                .buildTextMessage(new TextMessage()//
                        .setBody(Formatter.bold(Digester.survey.getTitreSondage()) + "\n"+ Digester.survey.getQuestionList().getIntitule() +"\n" + "1"+Digester.survey.getQuestionList().getPropositionList().get(1)+"\n"+ "2"+Digester.survey.getQuestionList().getPropositionList().get(2)+"\n"+ "3"+Digester.survey.getQuestionList().getPropositionList().get(3)+"\n"+  "4"+Digester.survey.getQuestionList().getPropositionList().get(4)+"\n"+ Formatter.bold(Digester.survey.getIdSondeur()))//
                        .setPreviewUrl(false));


        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);

    }
}
