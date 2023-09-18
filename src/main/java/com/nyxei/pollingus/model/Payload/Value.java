package com.nyxei.pollingus.model.Payload;

import lombok.Getter;

@Getter
public class Value {
    private String messagingProduct;
    private Metadata metadata;
    private Contacts[] contacts;
    private Messages[] messages;
}
