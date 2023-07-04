package com.nyxei.pollingus.models;

import lombok.Data;

@Data
public class Contact {
    private String wa_id;
    private Profile profile;

    @Override
    public String toString() {
        return "Contact{" +
                "wa_id='" + wa_id + '\'' +
                ", profile=" + profile +
                '}';
    }
}
