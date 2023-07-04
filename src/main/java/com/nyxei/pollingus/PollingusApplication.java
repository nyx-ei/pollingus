package com.nyxei.pollingus;

import com.nyxei.pollingus.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PollingusApplication implements CommandLineRunner {

	@Autowired
	NotificationRepository notificationRepository;

	public static void main(String[] args) {
		SpringApplication.run(PollingusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		notificationRepository.deleteAll();
	}
}
