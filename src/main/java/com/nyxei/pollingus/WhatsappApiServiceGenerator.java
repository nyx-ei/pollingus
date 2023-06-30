package com.nyxei.pollingus;

import com.nyxei.pollingus.configuration.WhatsappApiConfig;

import com.nyxei.pollingus.interceptor.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import java.io.IOException;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


import java.util.concurrent.TimeUnit;

public class WhatsappApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    final static int CALL_TIME_OUT_DURATION = 10;
    final static int PING_INTERVAL_DURATION = 10;

    static {

        sharedClient = new OkHttpClient.Builder()//
                .callTimeout(CALL_TIME_OUT_DURATION, TimeUnit.SECONDS)//
                .pingInterval(PING_INTERVAL_DURATION, TimeUnit.SECONDS)//
                .build();
    }
    public static <S> S setClient(Class<S> serviceClass, String token, String baseUrl) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converterFactory);

        if (token != null) {

            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String token) {

        var baseUrl = WhatsappApiConfig.BASE_DOMAIN;
        return setClient(serviceClass, token, baseUrl);

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
        }
        catch (IOException e) {
            return null; 
        }
    }

    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
