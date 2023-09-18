package com.nyxei.pollingus.model.Payload;

import lombok.Getter;

@Getter
public class Entry {
    private String id;
    private Changes[] changes;
}
