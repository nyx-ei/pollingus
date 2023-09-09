package com.nyxei.pollingus.domain.messages;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Button {
    @JsonProperty("label")
    private String label;
    @JsonProperty("action")
    private String action;

    public Button() {
    }

    public Button(String label, String action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setText(String buttonText) {
    }

    public void setValue(String buttonValue) {
    }
}
