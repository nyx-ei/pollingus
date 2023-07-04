package com.nyxei.pollingus.models;

import lombok.Data;

@Data
public class Profile {
    private String name;

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                '}';
    }
}
