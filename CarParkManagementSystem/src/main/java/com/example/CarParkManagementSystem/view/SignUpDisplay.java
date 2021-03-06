package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.dao.NewUserRepository;
import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@Document(collection = "user_table")
public class SignUpDisplay {
    public User tempUser;
    public User user;

    @Autowired
    private IParkingController iParkingController;

    @Autowired
    private NewUserRepository newUserRepository;

    @Autowired
    private NewUserService newUserService;

    @GetMapping("/signUp")
    public String signUpForm(Model model) {
        tempUser =new User();
        model.addAttribute("signUpTag", tempUser);
        return "signUp";
    }

    @PostMapping("/signUpTag")
        public String  createNewUser(@ModelAttribute User user, Model model) {

        User actual = iParkingController.getUser(user.getUsername(), user.getPassword());
        if (actual != null) {
//            model.addAttribute("failureMessage", failureMessage);
            return "signUp";
        }
        iParkingController.addUser(
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getAddress(),
                user.getContact_number(),
                user.getUsername(),
                user.getPassword(),
                user.getUser_type());
        model.addAttribute("user", user);
        return "signUpResult";
    }

//    @PutMapping("/user_table/{id}")
//    public ResponseEntity <User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        user.setUser_id(id);
//        return ResponseEntity.ok().body(this.newUserService.updateUser(user));
//    }
//
//    @GetMapping("/user_table/{id}")
//    public ResponseEntity <User> getUserById(@PathVariable Long id) {
//        return ResponseEntity.ok().body(newUserService.getUserById(id));
//    }

//    @GetMapping("/user_table/{id}")
//    public ResponseEntity < User > getUserByUserName(@PathVariable String user_name) {
//        return ResponseEntity.ok().body(newUserService.getUserByUserName(user_name));
//    }
}
