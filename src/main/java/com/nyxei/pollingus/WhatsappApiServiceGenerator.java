package com.nyxei.pollingus;

import com.nyxei.pollingus.configuration.WhatsappApiConfig;

//import com.nyxei.pollingus.exception.WhatsappApiException;
import com.nyxei.pollingus.interceptor.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import java.io.IOException;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


import java.util.concurrent.TimeUnit;

/**
 *
 */
public class WhatsappApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {

        sharedClient = new OkHttpClient.Builder()//
                .callTimeout(20, TimeUnit.SECONDS)//
                .pingInterval(20, TimeUnit.SECONDS)//
                .build();
    }

   



    public static <S> S createService(Class<S> serviceClass, String token, String baseUrl) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converterFactory);

        if (token == null) {
            retrofitBuilder.client(sharedClient);
        } else {

            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String token) {

       // var baseUrl = WhatsappApiConfig.BASE_DOMAIN;
       var baseUrl = WhatsappApiConfig.BASE_DOMAIN;
        return createService(serviceClass, token, baseUrl);

    }

    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            
        }
        else{
            return response.body();
        }
     } catch (IOException e) {
        return null; 
        }
        
    }

    

    

    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
