package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.controller.ParkingSystemController;
import com.example.CarParkManagementSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInDisplay {
    @Autowired
    IParkingController controller;

    @GetMapping("/signIn")
    public String signInForm(Model model) {
        model.addAttribute("signInTag", new User());
        return "signIn";
    }



    @PostMapping("/signInTag")
    public String signInSubmit(@ModelAttribute User user, Model model) {
        User actual = controller.getUser(user.getUsername(), user.getPassword());
        if (actual != null) {
            // Using signUpResult here because it gives full user information.
            // Both of these templates will need to be updated eventually,
            // and determining which template to use in code will also need
            // to be updated.
            model.addAttribute("user", actual);
            return "logInHome";
        }
        model.addAttribute("signUpTag", user);
        return "signUp";
    }



}
