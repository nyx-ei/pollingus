package com.nyxei.pollingus.domain.phone;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyxei.pollingus.domain.phone.type.CodeMethodType;
import com.nyxei.pollingus.domain.templates.type.LanguageType;

/**
 * The type Request code.
 *
 * @param codeMethod Required. Specifies the method for verification. Supported options are: SMS or VOICE.
 * @param language   Required. Specifies your locale.
 */
public record RequestCode(

        @JsonProperty("code_method") CodeMethodType codeMethod,

        @JsonProperty("language") LanguageType language) {
}