package com.nyxei.pollingus.repositories;

import com.nyxei.pollingus.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
