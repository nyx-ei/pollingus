package com.nyxei.pollingus.service;


import com.nyxei.pollingus.domain.messages.*;
import com.nyxei.pollingus.domain.messages.response.MessageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;


import static com.nyxei.pollingus.configuration.WhatsappApiConfig.API_VERSION;


public interface WhatsappBusinessCloudApiService {

    @POST("/" + API_VERSION + "/{Phone-Number-ID}/messages")
    Call<MessageResponse> sendMessage(@Path("Phone-Number-ID") String phoneNumberId, @Body Message message);

}
