package com.nyxei.pollingus.impl;
import static com.nyxei.pollingus.WhatsappApiServiceGenerator.createService;

import com.nyxei.pollingus.domain.media.FileType;
import com.nyxei.pollingus.domain.messages.Message;
import com.nyxei.pollingus.domain.messages.response.MessageResponse;
import com.nyxei.pollingus.service.WhatsappBusinessCloudApiService;

import okhttp3.MultipartBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;

import static com.nyxei.pollingus.WhatsappApiServiceGenerator.executeSync;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Implementation of WhatsApp Business Platform Cloud API with synchronous/blocking
 * method calls.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api">WhatsApp Business Platform Cloud API</a>
 */
public class WhatsappBusinessCloudApi {

    private WhatsappBusinessCloudApiService whatsappBusinessCloudApiService;

    public WhatsappBusinessCloudApi(String token) {
        this.whatsappBusinessCloudApiService = createService(WhatsappBusinessCloudApiService.class, token);

    }

    /**
     * Use this endpoint to send text, media, contacts, location, and interactive messages,
     * as well as message templates to your customers.
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param message       The {@link Message} object.
     * @return {@link MessageResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">official documentation</a>
     */
    public MessageResponse sendMessage(String phoneNumberId, Message message) {

        return executeSync(whatsappBusinessCloudApiService.sendMessage(phoneNumberId, message));
    }

        /**
     * You can use the endpoint to upload media:
     * All media files sent through this endpoint are encrypted and persist for 30 days, unless they are deleted earlier
     * <p>The maximum supported file size for media messages on Cloud API is 100MB. In the event the customer sends a file that is greater than 100MB, you will receive a webhook with error code 131052 and title:
     * "Media file size too big. Max file size we currently support: 100MB. Please communicate with your customer to send a media file that is smaller than 100MB"_.
     * We advise that you send customers a warning message that their media file exceeds the maximum file size when this webhook event is triggered.</p>
     *
     * @param phoneNumberId Business phone number ID. If included, the operation will only be processed if the ID matches the ID of the business phone number that the media was uploaded on.
     * @param fileName      file name. Ex: photo1.jpg
     * @param fileType      the file type. See {@link FileType}
     * @param file          byte[] - file content
     * @return {@link UploadResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
}
