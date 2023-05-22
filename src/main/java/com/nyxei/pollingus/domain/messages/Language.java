package com.nyxei.pollingus.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyxei.pollingus.domain.templates.type.LanguageType;

/**
 * @param code Language code. See {@link LanguageType}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Language(@JsonProperty("code") LanguageType code) {
}
