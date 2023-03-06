package com.nyxei.pollingus.domain.messages;


/**
 * Mandatory for message templates.
 * <p>
 * The type of message being sent.
 * Options:
 * <p>
 * - text( standard )
 * - image
 * - audio
 * - document
 * - template( use to send a media message template )
 * - hsm
 */
public enum MessageType {
    TEXT("text"), //
    IMAGE("image"), //
    AUDIO("audio"), //
    DOCUMENT("document"), //
    TEMPLATE("template"), //
    CONTACTS("contacts"),//
    HSM("hsm");//
    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
