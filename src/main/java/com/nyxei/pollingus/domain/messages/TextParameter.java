package com.nyxei.pollingus.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyxei.pollingus.domain.messages.type.ParameterType;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextParameter extends Parameter {
    @JsonProperty("text")
    private final String text;


    /**
     * Instantiates a new Text parameter.
     *
     * @param text the text
     */
    public TextParameter(String text) {
        super(ParameterType.TEXT);
        this.text = text;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

}
