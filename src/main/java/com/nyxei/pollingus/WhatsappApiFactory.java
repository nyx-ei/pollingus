package com.nyxei.pollingus;


import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;

public class WhatsappApiFactory {

    /**
     * Whatsapp token
     */
    String token;

    /**
     *  initialization of WhatsappApiFactory, WhatsappBusinessCloudApi instance
     */
    private static WhatsappApiFactory instanceWFactory = null;
    private static WhatsappBusinessCloudApi instanceWCloud = null;

    /**
     * Create a new whatsapp api factory
     *
     * @param token the whatsapp token
     */
    private WhatsappApiFactory(String token) {
        this.token = token;
    }

    public static WhatsappApiFactory getInstanceApiFactory(String apiKey) {
        if(instanceWFactory == null ){
            synchronized(WhatsappApiFactory.class){
                if(instanceWFactory == null){
                    instanceWFactory = new WhatsappApiFactory(apiKey);
                }
            }
        }
        return instanceWFactory;
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business cloud api client
     */
    public WhatsappBusinessCloudApi getInstanceBusinessCloudApi() {

        if(instanceWCloud == null) {
            synchronized(WhatsappBusinessCloudApi.class){
                if(instanceWCloud == null){
                    instanceWCloud = new WhatsappBusinessCloudApi(token);
                }
            }

        }
        return instanceWCloud;
    }
}
