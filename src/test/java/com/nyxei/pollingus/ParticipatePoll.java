package com.nyxei.pollingus;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.nyxei.pollingus.domain.messages.*;
import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;
import com.nyxei.pollingus.domain.messages.Message.MessageBuilder;


import static com.nyxei.pollingus.TestUtils.MESSAGE_CONTENT;
import static com.nyxei.pollingus.TestUtils.PHONE_NUMBER_1;

public class ParticipatePoll {
        public static void main(String[] args) {
            WhatsappApiFactory factory = WhatsappApiFactory.getInstanceApiFactory(TestUtils.TOKEN);
            WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.getInstanceBusinessCloudApi();

            String userPhoneNumber = PHONE_NUMBER_1;


            // Vérifier si c'est la première interaction de l'utilisateur
            if (isFirstInteraction(userPhoneNumber)) {

                // Créer les boutons de participation et de refus
                Button participateButton = createButton("Participer", "participate");
                Button declineButton = createButton("Décliner", "decline");

                // Créer la fenêtre d'invitation avec les boutons
                WindowMessage invitationWindow = createWindowMessage(MESSAGE_CONTENT, participateButton, declineButton);

                // Utiliser l'API WhatsApp pour envoyer la fenêtre d'invitation au sondage
                sendWhatsAppMessage(userPhoneNumber, invitationWindow, whatsappBusinessCloudApi);
            }
        }

        private static boolean isFirstInteraction(String userPhoneNumber) {
            // Logique pour vérifier si c'est la première interaction de l'utilisateur
            // Retourne true si c'est la première interaction, false sinon
            // Implémentez votre logique ici
            return false; // Exemple: toujours considéré comme la première interaction
        }

        private static Button createButton(String buttonText, String buttonValue) {
            Button button = new Button();
            button.setText(buttonText);
            button.setValue(buttonValue);
            return button;
        }

        private static WindowMessage createWindowMessage(String messageContent, Button participateButton, Button declineButton) {
            WindowMessage windowMessage = new WindowMessage();
            windowMessage.setContent(messageContent);
            windowMessage.addButtons(participateButton, declineButton);
            return windowMessage;
        }

    private static void sendWhatsAppMessage(String userPhoneNumber, WindowMessage windowMessage, WhatsappBusinessCloudApi whatsappBusinessCloudApi) {
        LoggingEventVO message = MessageBuilder.builder()
                .setTo(userPhoneNumber)
                .setWindowMessage(windowMessage)
                .build();

       // whatsappBusinessCloudApi.sendMessage(userPhoneNumber, windowMessage);
    }
    }
