package com.nyxei.pollingus.controller;


import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Controller
public class WebhookController {
    public static void envoitemplate (){

        final String URI_rappel = "https://graph.facebook.com/v15.0/102062986090216/messages";
        final String Token = "Bearer EAAGYN0OOscYBAMrCEYt6ExUxaZCC2lF3i1w43mDntNxPkhLzLJnJ4e0e3GohrIfkNPpasIzLodWONfQPOm1ns5dZChGe5jB5pZBejFC0WewuNgjZBzfEybElZAXlBNERq9grFLEt8WHEVT7Kpl4aVOQZC8kA5MC42aH6g3exhaOGpweK7xn5tlS7lKCZB3T4JgND2bQXUdC3O9KxuYkhSM1yZBKuETAp35kZD";
        final String Json = "application/json";
        final String Message = "{ \"messaging_product\": \"whatsapp\", \"to\": \"237694219581\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(URI_rappel))
                    .header("Authorization", Token)
                    .header("Content-Type",Json )
                    .POST(HttpRequest.BodyPublishers.ofString(Message))
                    .build();
            HttpClient http = HttpClient.newHttpClient();
            HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

