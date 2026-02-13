// package com.namedir.namedirectory.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.namedir.namedirectory.dto.UserRegistrationDto;
// import com.namedir.namedirectory.service.UserRegistrationService;

// @Controller
// public class LoginController {

//     private final UserRegistrationService userRegistrationService;

//     public LoginController(UserRegistrationService userRegistrationService) {
//         this.userRegistrationService = userRegistrationService;
//     }
    
//     @GetMapping("/login")
//     public String showLoginPage(){

//         return "login";
//     }

//     @GetMapping("/register")
//     public String showRegistrationForm(Model model){

//         model.addAttribute("user", new UserRegistrationDto());

//         return "registration-form";
//     }

//     @PostMapping("/register/save")
//     public String registerUser(@ModelAttribute("user") UserRegistrationDto dto){

//         userRegistrationService.registerUser(dto);

//         return "redirect:/login?success";
      
//     }

// }
