package com.namedir.namedirectory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NameController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
