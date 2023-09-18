package com.nyxei.pollingus.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="media")
@Data
public class MessageEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_name")
    private String userName;

    @Column(name = "sender_number")
    private String senderNumber;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "image_caption")
    private String imageCaption;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "sha_256")
    private String sha256;

}
