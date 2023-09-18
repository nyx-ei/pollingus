package com.nyxei.pollingus.model.Payload;

import lombok.Getter;

@Getter
public class Request {
    private String object;
    private Entry[] entry;
}
