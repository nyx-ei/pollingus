package com.nyxei.pollingus;

import com.nyxei.pollingus.model.Digester;
import com.nyxei.pollingus.model.MultipleQuestion;
import com.nyxei.pollingus.domain.messages.Message.MessageBuilder;
import com.nyxei.pollingus.domain.messages.TextMessage;
import com.nyxei.pollingus.exception.utils.Formatter;
import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;



import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_ID;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PollingusApplicationTests {

	@Test
	void contextLoads() {
	//}
	//public static void main( String[] args ) throws Exception {
	
	String file = "testVS.json";
	WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestUtils.TOKEN);
        
	try ( PrintWriter writer = new PrintWriter( file ) ) {
		
	 String intitule= MultipleQuestion.intituleQuestion();
	 ArrayList<String> proposition= (ArrayList<String>) MultipleQuestion.propositionQuestion();
	 System.out.println(proposition.get(0));
	 MultipleQuestion.writeObject( intitule, writer );
	 MultipleQuestion.writeObject( proposition, writer );
	}
	catch(Exception e){
		System.out.println(e);
	}
	// Survey survey= new Survey(Digester.ObjectSurvey());

	

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
