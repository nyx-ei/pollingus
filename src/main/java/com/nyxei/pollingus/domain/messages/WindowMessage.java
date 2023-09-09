package com.nyxei.pollingus.domain.messages;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyxei.pollingus.domain.Component;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WindowMessage {
    @JsonProperty("title")
    private String title;
    @JsonProperty("main_content")
    private String mainContent;
    @JsonProperty("buttons")
    private List<Button> buttons;
    private Component<?> button;


    public WindowMessage() {
    }

    public WindowMessage(String title, String mainContent, List<Button> buttons) {
        this.title = title;
        this.mainContent = mainContent;
        this.buttons = buttons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public Component<?> addButton(Button button) {
        buttons.add(button);
        return this.button;
    }

    public void removeButton(Button button) {
        buttons.remove(button);
    }

    public void setContent(String messageContent) {
    }


    public void addButtons(Button participateButton, Button declineButton) {

    }

    public LoggingEventVO build() {
        return null;
    }
}
