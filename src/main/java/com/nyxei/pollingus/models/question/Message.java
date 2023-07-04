package com.nyxei.pollingus.models.question;

import lombok.Data;

@Data
public class Message {
    private String id;
    private String from;
    private String text;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
