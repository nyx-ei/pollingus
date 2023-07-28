package com.nyxei.pollingus.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

public interface MessageEntityRepository extends JpaRepository<MessageEntity, Long> {
}
