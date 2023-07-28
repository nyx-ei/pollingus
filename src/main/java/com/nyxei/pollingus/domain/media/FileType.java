package com.nyxei.pollingus.domain.media;

import com.fasterxml.jackson.annotation.JsonValue;


    

    /**
 * Supported Media Types
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media#supported-media-types">whatsapp official documentation</a>
 */
public enum FileType {

    /**
     * Jpeg file type.
     */
     JPEG("image/jpeg"),
    /**
     * Png file type.
     */
    PNG("image/png");

    private final String type;

    FileType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}


