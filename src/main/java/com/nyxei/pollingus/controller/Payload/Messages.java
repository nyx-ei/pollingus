package com.nyxei.pollingus.controller.Payload;

import lombok.Getter;

@Getter
public class Messages {
    private String from;
    private String id;
    private String timestamp;
    private Image image;
    private String type;
}
