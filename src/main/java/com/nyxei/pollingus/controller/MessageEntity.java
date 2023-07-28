package com.nyxei.pollingus.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class MessageEntity extends AbstractPersistable<Long> {
    private String senderNumber;
    private String message;
    private Date timestamp;
}
