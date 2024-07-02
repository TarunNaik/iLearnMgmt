package com.practice.hexagonal.edutech.ilearnmgmt.controller;

import com.practice.hexagonal.edutech.ilearnmgmt.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/index")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "user/register";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

//    @GetMapping(value = "/{userName}")
//    public String hello(@PathVariable String userName) {
//        return "Hello " + userName;
//    }
}
