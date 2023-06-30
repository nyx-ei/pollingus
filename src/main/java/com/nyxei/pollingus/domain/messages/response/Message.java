package com.nyxei.pollingus.domain.messages.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Message(

        @JsonProperty("id") String id) {
}
