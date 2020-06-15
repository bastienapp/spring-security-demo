package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class LoginController {

    @RolesAllowed("USER")
    @GetMapping("/")
    public String getUser() {
        return "Welcome User";
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome Admin";
    }
}
