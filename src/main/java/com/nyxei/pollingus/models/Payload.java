package com.nyxei.pollingus.models;

import java.util.ArrayList;
import java.util.List;

public class Payload {
    private String object;
    private List<Entry> entry = new ArrayList<>();

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

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
