package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/")
    @ResponseBody
    public String getUser() {
        return "Welcome User";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String getAdmin() {
        return "Welcome Admin";
    }
}