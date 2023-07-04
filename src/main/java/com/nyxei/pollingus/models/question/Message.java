package com.nyxei.pollingus.models.question;

public class Message {
    private String id;
    private String from;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
