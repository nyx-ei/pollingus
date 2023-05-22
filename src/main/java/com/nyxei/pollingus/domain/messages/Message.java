package com.nyxei.pollingus.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyxei.pollingus.domain.messages.type.MessageType;



/**
 * To send a message, you must first assemble a message object with the content you want to send.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">API documentation - messages</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    @JsonProperty("messaging_product")
    private final String messagingProduct = "whatsapp";
    @JsonProperty("recipient_type")
    private final String recipientType = "individual";
    /**
     * The Interactive message.
     */

    @JsonProperty("to")
    private String to;
    @JsonProperty("type")
    private MessageType type;
   
    @JsonProperty("template")
    private TemplateMessage templateMessage;


    private Message() {
    }

    private Message(String to, MessageType type) {
        this.to = to;
        this.type = type;
    }

    /**
     * Gets messaging product.
     *
     * @return the messaging product
     */
    public String getMessagingProduct() {
        return messagingProduct;
    }

    /**
     * Gets recipient type.
     *
     * @return the recipient type
     */
    public String getRecipientType() {
        return recipientType;
    }

	/**
     * The type Message builder.
     */
    public static class MessageBuilder {

        private String to;


        private MessageBuilder() {
        }

        /**
         * Builder message builder.
         *
         * @return the message builder
         */
        public static MessageBuilder builder() {
            return new MessageBuilder();
        }

        /**
         *
         *
         * @param to Required.           <p>           WhatsApp ID or phone number for the person you want to send a message to.
         * @return the to
         */
        public MessageBuilder setTo(String to) {
            this.to = to;
            return this;
        }

       

        /**
         * Build template message
         *
         * @param templateMessage the template message
         * @return the message
         * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages#template-object">API documentation</a>
         */
        public Message buildTemplateMessage(TemplateMessage templateMessage) {
            var message = new Message(to, MessageType.TEMPLATE);
            message.templateMessage = templateMessage;
            return message;

        }

    
        





      



      
        

    }

}

