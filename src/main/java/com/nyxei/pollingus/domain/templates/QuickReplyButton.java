package com.nyxei.pollingus.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyxei.pollingus.domain.templates.type.ButtonType;

/**
 * The type Quick reply button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuickReplyButton extends Button {
    /**
     * Instantiates a new Quick reply button.
     */
    protected QuickReplyButton() {
        super(ButtonType.QUICK_REPLY);
    }

    /**
     * Instantiates a new Quick reply button.
     *
     * @param text the text
     */
    public QuickReplyButton(String text) {
        super(ButtonType.QUICK_REPLY, text);
    }


}
