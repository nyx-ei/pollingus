package com.nyxei.pollingus.controllers;

import com.nyxei.pollingus.repositories.NotificationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notifications")
public class PollController {
    private final NotificationRepository notificationRepository;

    public PollController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    public String display(Model model){
        model.addAttribute("notifications", notificationRepository.findAll());
        return "poll";
    }
}
