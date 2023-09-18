package com.nyxei.pollingus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nyxei.pollingus.model.MessageEntity;

@Repository
public interface MessageEntityRepository extends CrudRepository<MessageEntity, Integer> {
}
