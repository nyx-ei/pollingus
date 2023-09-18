package com.nyxei.pollingus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nyxei.pollingus.model.MessageEntity;
import com.nyxei.pollingus.repository.MessageEntityRepository;

import lombok.Data;

@Data
@Service
public class MessageEntityService {
    @Autowired
    private MessageEntityRepository messageEntityRepository;

    public MessageEntity saveMessage(MessageEntity message){
        return this.messageEntityRepository.save(message);
    }
    
}
