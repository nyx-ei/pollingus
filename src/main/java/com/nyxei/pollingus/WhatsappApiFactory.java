package com.nyxei.pollingus;


import com.nyxei.pollingus.impl.WhatsappBusinessCloudApi;
import com.nyxei.pollingus.impl.WhatsappBusinessManagementApi;

/**
 * A factory for creating Whatsapp api client objects.
 */
public class WhatsappApiFactory {
   /**
     * Whatsapp token
     */
    public static String token;
    /**
     * new instance of WhatsappApiFactory,WhatsappBusinessCloudApi,WhatsappBusinessManagementApi according to the singleton pattern
     */
    private static WhatsappApiFactory instanceWFactory = new WhatsappApiFactory();
    private static WhatsappBusinessCloudApi instanceWCloud = new WhatsappBusinessCloudApi(token);
    private static WhatsappBusinessManagementApi instanceWManagement = new WhatsappBusinessManagementApi(token);

    /**
      * set apiKey with the token
      */
    private String apiKey;

    /**
     * Create a new whatsapp api factory
     *
     * @param token the whatsapp token
     */
    private WhatsappApiFactory() {
        this.apiKey = token;
    }

    /**
     * New instance whatsapp api factory.
     *
     * @return the whatsapp api factory
     */
    public static WhatsappApiFactory getInstance() {
       return instanceWFactory;
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business cloud api client
     *
     * @return the whatsapp business cloud api
     */
    public WhatsappBusinessCloudApi getBusinessCloudApi() {
        return instanceWCloud;
    }

    /**
     * Creates a new synchronous/blocking Whatsapp business management api client
     *
     * @return the whatsapp business management api
     */
    public WhatsappBusinessManagementApi getBusinessManagementApi() {
        return instanceWManagement;
    }
}
