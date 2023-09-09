package com.nyxei.pollingus.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyxei.pollingus.domain.Component;
import com.nyxei.pollingus.domain.Language;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonTemplateMessage {
    @JsonProperty("components")
    private List<Component<?>> components;
    @JsonProperty("name")
    private String name;
    @JsonProperty("language")
    private Language language;

    public List<Component<?>> getComponents() {
        return components;
    }

    public ButtonTemplateMessage setComponents(List<Component<?>> components) {
        this.components = components;
        return this;
    }

    public String getName() {
        return name;
    }

    public ButtonTemplateMessage setName(String name) {
        this.name = name;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public ButtonTemplateMessage setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public ButtonTemplateMessage addComponent(Component<?> component) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(component);
        return this;
    }
}