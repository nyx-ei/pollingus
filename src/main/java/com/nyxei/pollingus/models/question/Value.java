package com.nyxei.pollingus.models.question;

import com.nyxei.pollingus.models.Contact;
import lombok.Data;

import java.util.List;

@Data
public class Value {
    private String messaging_product;
    private List<Message> messages;
    private List<Contact> contacts;

    @Override
    public String toString() {
        return "Value{" +
                "messaging_product='" + messaging_product + '\'' +
                ", messages=" + messages +
                ", contacts=" + contacts +
                '}';
    }
}
