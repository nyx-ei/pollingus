package com.nyxei.pollingus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerContact {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/createContact")
    public String createContact(){
        return "createContact";
    }
}
