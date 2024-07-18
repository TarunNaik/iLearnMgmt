package com.practice.hexagonal.edutech.ilearnmgmt.adaptor.in.web;

import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;
import com.practice.hexagonal.edutech.ilearnmgmt.application.port.in.FindUserUseCase;
import com.practice.hexagonal.edutech.ilearnmgmt.application.port.in.UserRegistrationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequiredArgsConstructor
public class UserController {
    private FindUserUseCase findUserUseCase;
    private UserRegistrationUseCase userRegistrationUseCase;

    public UserController(FindUserUseCase findUserUseCase, UserRegistrationUseCase userRegistrationUseCase) {
        this.findUserUseCase = findUserUseCase;
        this.userRegistrationUseCase = userRegistrationUseCase;
    }
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

    @PostMapping(value = "/register/save")
    public String registerUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult result, Model model){
        //find if user is already registered
        UserDTO existingUser = findUserUseCase.findUserByEmail(userDTO.getEmail());
        if(existingUser != null && existingUser.getId() != null ) {
            result.rejectValue("email", null, "User is already registered, Login using the credential");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDTO);
            return "redirect:/register?failure";
        }
        userRegistrationUseCase.registerUser(userDTO);
        return "redirect:/register?success";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }


}
