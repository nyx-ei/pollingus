package com.nyxei.pollingus;

import com.nyxei.pollingus.controller.WebhookController;
import com.nyxei.pollingus.service.SerializableDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;






@SpringBootApplication
public class PollingusApplication {

	// create a dao for serialization
	private static final SerializableDAO dao = new SerializableDAO();

	public static void main(String[] args) {

		SpringApplication.run(PollingusApplication.class, args);
		WebhookController.envoitemplate();

	}
}



