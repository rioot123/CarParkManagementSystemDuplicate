package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.dao.DAO;
import com.example.CarParkManagementSystem.model.Greeting;
import com.example.CarParkManagementSystem.model.User;
import com.example.CarParkManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
//@RequestMapping("/users")
public class Controller_Class {
    User user = new User();

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", user);
        return "signIn";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("greeting", user);
        return "result";
    }
//    @RequestMapping("/")
//    public String setData(Model model)
//    {
////        User user=new User();
////        model.addAttribute(user.first_name,"message");
//        model.addAttribute("message","Change message");
//        return "signIn";
//    }
//
//    @GetMapping("/")
//    public String getData(Model model)
//    {
//        User user=new User();
//        model.addAttribute("greeting",user);
//        return "greeting";
//    }
//
//    @GetMapping("/greeting")
//    public String greetingForm(Model model) {
//        model.addAttribute("greeting", new Greeting());
//        return "signIn";
//    }

//    @Autowired
//    private UserService userService;

    //    @GetMapping
//    public Collection<User> getUser()
//    {
//        return userService.getUser();
//    }



//    @PostMapping()
//    public User postUser(@RequestBody User temp)
//    {
//        temp=user;
//        return userService.createUser(temp);
//    }

}
