package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String getUser() {
        return "Welcome User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome Admin";
    }
}