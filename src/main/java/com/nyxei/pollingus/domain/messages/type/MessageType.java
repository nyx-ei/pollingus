package com.nyxei.pollingus.domain.messages.type;
//TODO: implementar mais tipos de mensagens. Não está completo.

import com.fasterxml.jackson.annotation.JsonValue;


public enum MessageType {
    
    CONTACTS("contacts"),//
    /**
     * Document message type.
     */
    DOCUMENT("document"), //
    /**
     * Location message type.
     */
    
    TEXT("text"), //
    /**
     * Template message type.
     */
    TEMPLATE("template"), //
    /**
     * Image message type.
     */
    IMAGE("image"), //
    
    @Deprecated(forRemoval = true) HSM("hsm");//

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
