package com.nyxei.pollingus.controller.Payload;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Request {
    private String object;
    private Entry[] entry;
}
