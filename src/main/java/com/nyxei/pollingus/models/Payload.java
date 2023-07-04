package com.nyxei.pollingus.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Payload {
    private String object;
    private List<Entry> entry = new ArrayList<>();

    @Override
    public String toString() {
        return "Payload{" +
                "object='" + object + '\'' +
                ", entry=" + entry +
                '}';
    }

    public Payload() {
    }
}
