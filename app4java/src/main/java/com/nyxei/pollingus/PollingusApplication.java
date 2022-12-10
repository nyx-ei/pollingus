package com.nyxei.pollingus;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PollingusApplication {

	public static void main(String[] args) {
		 

		try {
			HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("https://graph.facebook.com/v15.0/102062986090216/messages"))
				.header("Authorization", "Bearer EAAGYN0OOscYBAKr9XGGCllZBFZC9XAIJDwAVGAlkDMWdhMElo6aJbWbsMu2W7pZCfObN39uAHqdZAcDNx5qmPlVv88wmiZBva7YnEqzJ3C2hzUiZAFZCdD9zCjUQ193touuz6qqE3VNgwCKtYhW0Cq8bkgxtgdx2COdx5VRwsEcbQjO3w7VQazLgMvy7TxsR9ZANIvIgdFcYTWY1RZAvwDuSH")
				.header("Content-Type", "application/json")
				 .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \"237694219581\", \"type\": \"template\", \"template\": { \"name\": \"nouvelle_offre\", \"language\": { \"code\": \"fr\" } } }"))
				 // .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \"237694219581\", \"type\": \"template\", \"template\": { \"name\": \"_new_customer_offer\", \"language\": { \"code\": \"fr\" }, \"components\":[{\"type\":\"header\",\"parameters\":[{\"type\":\"image\",\"image\":{\"link\":\"https://images.app.goo.gl/HFdZU5Zf1Sx5wyBb9\"}}]}, ] } }"))
				.build();
			HttpClient http = HttpClient.newHttpClient();
			HttpResponse<String> response = http.send(request,BodyHandlers.ofString());
			System.out.println(response.body());
		   
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
		// SpringApplication.run(PollingusApplication.class, args);
	}

}
