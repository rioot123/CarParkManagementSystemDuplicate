package com.example.CarParkManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
    @RequestMapping("/signIn")
    public  String getHomePage(){
        return "signIn";
    }
}
