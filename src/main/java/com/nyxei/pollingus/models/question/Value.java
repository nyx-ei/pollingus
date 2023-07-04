package com.nyxei.pollingus.models.question;

import com.nyxei.pollingus.models.Contact;

import java.util.List;

public class Value {
    private String messaging_product;
    private List<Message> messages;
    private List<Contact> contacts;

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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Value{" +
                "messaging_product='" + messaging_product + '\'' +
                ", messages=" + messages +
                ", contacts=" + contacts +
                '}';
    }
}
