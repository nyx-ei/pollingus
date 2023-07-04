package com.nyxei.pollingus.models.question;

import java.util.List;

public class Value {
    private String messaging_product;
    private List<Message> messages;

    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Value{" +
                "messaging_product='" + messaging_product + '\'' +
                ", messages=" + messages +
                '}';
    }
}
