package com.nyxei.pollingus.models;

public class Contact {
    private String wa_id;
    private Profile profile;

    public String getWa_id() {
        return wa_id;
    }

    public void setWa_id(String wa_id) {
        this.wa_id = wa_id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "wa_id='" + wa_id + '\'' +
                ", profile=" + profile +
                '}';
    }
}
